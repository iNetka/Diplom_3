package site.stellarburgers.nomoreparties.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import site.stellarburgers.nomoreparties.model.User;
import site.stellarburgers.nomoreparties.request.RegisterUserRequest;

import static io.restassured.RestAssured.given;

public class ApiUser extends ApiClient {

    private static final String REGISTER = "auth/register/";
    private static final String LOGIN = "auth/login/";
    private static final String DELETE = "auth/user/";


    @Step("Логин пользователя")
    public Response login(Credentials credentials) {
        return given()
                .spec(getSpecSettings())
                .body(credentials)
                .when()
                .post(LOGIN);
    }

    @Step("Create user")
    public Response registerUser(User user) {

        Response response = given()
                .spec(getSpecSettings())
                .body(new RegisterUserRequest(user.getName(), user.getEmail(), user.getPassword()))
                .when()
                .post(REGISTER);

        String accessToken = response.getBody().jsonPath().getString("accessToken");
        String refreshToken = response.getBody().jsonPath().getString("refreshToken");

        user.setAccessToken(accessToken);
        user.setRefreshToken(refreshToken);
        return response;
    }

    @Step("Удаление пользователя")
    public Response delete(Response response) {
        String accessToken = response.body().jsonPath().getString("accessToken");
        if (accessToken == null) {
            return null;
        }
        return (Response) given()
                .spec(getSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(DELETE)
                .then()
                .extract();
    }

    @Step("Удаление пользователя")
    public Response delete(String accessToken) {
        if (accessToken == null) {
            return null;
        }
        return given()
                .spec(getSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(DELETE);
    }
}
