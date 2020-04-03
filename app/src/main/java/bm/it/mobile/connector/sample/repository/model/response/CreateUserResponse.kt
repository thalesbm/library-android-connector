package bm.it.mobile.connector.sample.repository.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreateUserResponse(
    @SerializedName("name") @Expose val name: String,
    @SerializedName("job") @Expose val job: String
)