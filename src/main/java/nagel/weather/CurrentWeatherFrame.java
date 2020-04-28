package nagel.weather;

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;

public class CurrentWeatherFrame extends JFrame {
    Retrofit retrofit;

    private JLabel zipLabel;
    private JTextField zip;
    private JLabel error;
    private JLabel cityLabel;
    private JLabel city;
    private JLabel tempLabel;
    private JLabel temp;
    private JLabel feelsLikeLabel;
    private JLabel feelsLike;
    private JLabel descriptionLabel;
    private JLabel description;
    private JButton search;
    private JButton clear;

    private JPanel topPanel;
    private JPanel midPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel botPanel;

    public CurrentWeatherFrame() {
        setSize(300,200);
        setTitle("Weather");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        zipLabel = new JLabel("Enter zip code:");
        zip = new JTextField();
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        topPanel.add(zipLabel);
        topPanel.add(zip);

        error = new JLabel();
        cityLabel = new JLabel();
        city = new JLabel();
        tempLabel = new JLabel();
        temp = new JLabel();
        feelsLikeLabel = new JLabel();
        feelsLike = new JLabel();
        descriptionLabel = new JLabel();
        description = new JLabel();

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4,1));
        leftPanel.add(cityLabel);
        leftPanel.add(tempLabel);
        leftPanel.add(feelsLikeLabel);
        leftPanel.add(descriptionLabel);

        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4,1));
        rightPanel.add(city);
        rightPanel.add(temp);
        rightPanel.add(feelsLike);
        rightPanel.add(description);

        midPanel = new JPanel();
        midPanel.add(leftPanel, BorderLayout.WEST);
        midPanel.add(rightPanel, BorderLayout.EAST);
        midPanel.add(error);
        error.setAlignmentX(CENTER_ALIGNMENT);
        error.setForeground(Color.RED);

        search = new JButton("Search");
        search.addActionListener(actionEvent -> getWeather());
        clear = new JButton("Clear");
        clear.addActionListener(actionEvent -> reset());
        botPanel = new JPanel();
        botPanel.add(search);
        botPanel.add(clear);

        add(topPanel, BorderLayout.PAGE_START);
        add(midPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.PAGE_END);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void getWeather() {
            WeatherService service = retrofit.create(WeatherService.class);

            service.getWeather(zip.getText() + ",us").enqueue(new Callback<CurrentWeather>() {

                @Override
                public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response)
                {
                    CurrentWeather currentWeather = response.body();
                    error.setText("");
                    cityLabel.setText("City:");
                    city.setText(currentWeather.name);
                    tempLabel.setText("Temperature:");
                    temp.setText(currentWeather.main.temp + " " + ((char)176) + "F");
                    feelsLikeLabel.setText("Feels Like:");
                    feelsLike.setText(currentWeather.main.feels_like + " " + ((char)176) + "F");
                    descriptionLabel.setText("Description:");
                    description.setText(currentWeather.weather[0].description);
                }

                @Override
                public void onFailure(Call<CurrentWeather> call, Throwable t)
                {
                    reset();
                    error.setText("Error occurred. Please try again.");
                }
            });
    }

    private void reset() {
        zip.setText("");
        error.setText("");
        cityLabel.setText("");
        city.setText("");
        tempLabel.setText("");
        temp.setText("");
        feelsLikeLabel.setText("");
        feelsLike.setText("");
        descriptionLabel.setText("");
        description.setText("");
    }

    public static void main(String[] args) {
        new nagel.weather.CurrentWeatherFrame().setVisible(true);
    }
}

