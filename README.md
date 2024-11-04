# USGS Earthquake Tracker

## Overview

The USGS Earthquake Tracker is a full-stack application that provides real-time visualization of earthquake data from the United States Geological Survey (USGS). It combines a Spring Boot backend with a React frontend to fetch, process, and display earthquake information and seismograph data.

## Technologies Used

### Backend
- Java 17
- Spring Boot 2.6.3
- Spring Web
- Spring WebFlux
- Project Lombok
- Jackson (for JSON processing)
- Maven (for dependency management)

### Frontend
- React 17
- Chart.js and react-chartjs-2 (for seismograph visualization)
- Google Maps JavaScript API (for mapping earthquakes)

### APIs
- USGS Earthquake API
- Google Maps JavaScript API

## Architecture

The application follows a microservices architecture with a clear separation between the backend and frontend:

1. **Spring Boot Backend**:
   - Fetches real-time earthquake data from the USGS API
   - Processes and serves data to the frontend via RESTful endpoints
   - Generates mock seismograph data for visualization

2. **React Frontend**:
   - Consumes data from the backend API
   - Renders an interactive map using Google Maps API
   - Displays a seismograph chart using Chart.js

## Key Components

### Backend

1. **EarthquakeTrackerApplication**: The main Spring Boot application class.

2. **WebConfig**: Configures CORS settings for cross-origin requests.

3. **EarthquakeController**: Handles HTTP requests for earthquake data.

4. **SeismographController**: Manages requests for seismograph data.

5. **EarthquakeService**: Business logic for processing earthquake data.

6. **SeismographService**: Generates mock seismograph data.

7. **USGSApiClient**: Utilizes WebClient to fetch data from the USGS API.

8. **Earthquake**: Model class representing earthquake data.

9. **SeismographData**: Model class for seismograph data.

### Frontend

1. **App.js**: Main React component orchestrating the application.

2. **EarthquakeMap.js**: React component for rendering the Google Maps interface.

3. **SeismographChart.js**: React component for displaying seismograph data using Chart.js.

## API Endpoints

1. `GET /api/earthquakes`: Retrieves recent earthquake data.
2. `GET /api/seismograph`: Fetches seismograph data.

## Setup and Installation

### Prerequisites
- JDK 17 or later
- Node.js and npm
- Maven
- Google Maps API key

### Backend Setup
1. Clone the repository.
2. Navigate to the project root directory.
3. Run `mvn clean install` to build the project and download dependencies.
4. Start the Spring Boot application using `mvn spring-boot:run`.

### Frontend Setup
1. Navigate to the `frontend` directory.
2. Run `npm install` to install dependencies.
3. Create a `.env` file and add your Google Maps API key:
   ```
   REACT_APP_GOOGLE_MAPS_API_KEY=your_api_key_here
   ```
4. Start the React development server with `npm start`.

## Running the Application

1. Ensure the Spring Boot backend is running on `http://localhost:8080`.
2. Start the React frontend, which will run on `http://localhost:3000`.
3. Access the application through a web browser at `http://localhost:3000`.

## Key Features

1. **Real-time Earthquake Data**: Fetches and displays the latest earthquake information from USGS.
2. **Interactive Map**: Visualizes earthquake locations using Google Maps, with markers indicating magnitude and location.
3. **Seismograph Visualization**: Displays a mock seismograph chart for educational purposes.
4. **Responsive Design**: Adapts to various screen sizes for optimal viewing on different devices.

## Data Flow

1. The backend periodically fetches earthquake data from the USGS API.
2. Earthquake data is processed and stored in-memory.
3. The frontend requests data from the backend API.
4. Received data is rendered on the map and in the seismograph chart.

## Performance Considerations

- The application uses reactive programming (WebFlux) for efficient handling of concurrent requests.
- Frontend optimizations include lazy loading of components and efficient re-rendering strategies.

## Security

- CORS is configured to allow requests only from the frontend origin.
- The Google Maps API key should be kept confidential and not exposed in public repositories.

## Future Enhancements

1. Implement real-time updates using WebSocket connections.
2. Add user authentication and personalized earthquake alerts.
3. Integrate machine learning models for earthquake prediction.
4. Expand the application to include historical earthquake data analysis.
