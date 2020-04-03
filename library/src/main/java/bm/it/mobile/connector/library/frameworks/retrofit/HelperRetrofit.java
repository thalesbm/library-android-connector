package bm.it.mobile.connector.library.frameworks.retrofit;

import java.io.IOException;

import bm.it.mobile.connector.library.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RETROFIT
 */
public class HelperRetrofit {

    private Retrofit retrofit = null;

    public Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHTTPClient().build())
                    .build();
        }
        return retrofit;
    }

    private OkHttpClient.Builder getHTTPClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // SET HEADERS
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                // Request request = chain.request();
                // Request.Builder header = request.newBuilder().addHeader("", "");
                // return chain.proceed(header.build());
                return null;
            }
        });

        // SET LOG
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor);
        }
        return builder;
    }
}
