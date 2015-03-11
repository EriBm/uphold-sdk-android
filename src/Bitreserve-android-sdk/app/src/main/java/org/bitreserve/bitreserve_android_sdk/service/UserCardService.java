package org.bitreserve.bitreserve_android_sdk.service;

import org.bitreserve.bitreserve_android_sdk.model.Card;
import org.bitreserve.bitreserve_android_sdk.model.Transaction;
import org.bitreserve.bitreserve_android_sdk.model.card.CardRequest;
import org.bitreserve.bitreserve_android_sdk.model.transaction.TransactionRequest;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Has the user card webservice endpoints.
 */

public interface UserCardService {

    /**
     * Performs a request to cancel a transaction.
     *
     * @param cardId The id of the card.
     * @param transactionId The id of the transaction.
     * @param callback A callback to receive the request information.
     */

    @POST("/v0/me/cards/{cardId}/transactions/{transactionId}/cancel")
    void cancelTransaction(@Path("cardId") String cardId, @Path("transactionId") String transactionId, Callback<Transaction> callback);

    /**
     * Performs a request to confirm a transaction.
     *
     * @param cardId The id of the card.
     * @param transactionId The id of the transaction.
     * @param callback A callback to receive the request information.
     */

    @POST("/v0/me/cards/{cardId}/transactions/{transactionId}/commit")
    void confirmTransaction(@Path("cardId") String cardId, @Path("transactionId") String transactionId, Callback<Transaction> callback);

    /**
     * Performs a request to create a transaction for a card.
     *
     * @param cardId The id of the card.
     * @param transaction The {@link TransactionRequest} information
     * @param callback A callback to receive the request information.
     */

    @POST("/v0/me/cards/{cardId}/transactions")
    void createTransaction(@Path("cardId") String cardId, @Body TransactionRequest transaction, Callback<Transaction> callback);

    /**
     * Performs a request to get a specific user card.
     *
     * @param cardRequest The {@link CardRequest} information.
     * @param callback A callback to receive the request information.
     */

    @POST("/v0/me/cards")
    void createUserCard(@Body CardRequest cardRequest, Callback<Card> callback);

    /**
     * Performs a request to get a specific user card.
     *
     * @param cardId The id of the card.
     * @param callback A callback to receive the request information.
     */

    @GET("/v0/me/cards/{cardId}")
    void getUserCardById(@Path("cardId") String cardId, Callback<Card> callback);

    /**
     * Performs a request to get the user cards.
     *
     * @param callback A callback to receive the request information.
     */

    @GET("/v0/me/cards")
    void getUserCards(Callback<List<Card>> callback);

    /**
     * Performs a request to get the list of transactions for a card.
     *
     * @param cardId The id of the card.
     * @param callback A callback to receive the request information.
     */

    @GET("/v0/me/cards/{cardId}/transactions")
    void getUserCardTransactions(@Path("cardId") String cardId, Callback<List<Transaction>> callback);

}
