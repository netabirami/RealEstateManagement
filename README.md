# Real Estate Property Listing System

## Project Overview

Create a Real Estate Property Listing System using Java Spring Boot and Spring Data JPA. This system manages property listings, enabling users to add, view, update, and delete property details.

## Day 1: Spring Data JPA

### Requirements

#### 1. Project Setup

Generate the project using Spring Initializr with dependencies: Spring Web, Spring Data JPA, and a MySQL database.

#### 2. Database Model

- Define a Property entity with attributes: id, address, type (e.g., apartment, house), price, area, bedrooms, bathrooms, and listingDate.
- Create a Realtor entity with attributes such as id, name, email, and phone.
- Establish a One-to-Many relationship between Realtor and Property (one realtor can have many properties).

#### 3. Repository Layer

- Create a JPA repository for the Property entity.
- Create a JPA repository for the Realtor entity.

#### 4. Service Layer

Develop the service layer to manage the business logic, interacting with the property and realtor repository.

#### 5. Controller Layer

Implement RESTful endpoints:

- GET /properties to list all properties.
- GET /properties/{id} to retrieve a specific property.
- POST /properties to create a new property listing.
- PUT /properties/{id} to update an existing property.
- DELETE /properties/{id} to delete a property listing.

#### 6. Data Validation

Implement Spring validation for property data during creation and updating (required fields, etc.).

#### 7. Database Configuration

Configure and initialize the MySQL database with some sample property listings.

## Additional Information

- This project was created as part of a mini-project for learning Spring Data JPA.
- Feel free to explore, contribute, and provide feedback.

