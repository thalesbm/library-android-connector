package bm.it.mobile.connector.sample.repository.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateUserRequest(
    @SerializedName("name") @Expose val name: String,
    @SerializedName("job") @Expose val job: String
)