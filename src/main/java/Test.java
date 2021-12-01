import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_MIGRATION_API;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_NOTIFICATIONS_API;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;

import io.swagger.client.api.SellersApi;

public class Test {

	public static void main(String[] args) throws Exception {
		LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
				.clientId("amzn1.application-oa2-client.421e5db698984be18d71d536ef37acdd")
				.clientSecret("d155c49bc098034eab6342c19dcaa8b8db45b7ecc3208cc0f2f8121f90029a8e")
				.withScopes(SCOPE_NOTIFICATIONS_API, SCOPE_MIGRATION_API)
				.refreshToken(
						"Atzr|IwEBIE04VN7feiMspntuP2KhV0L2nalLjeGpoyOkVBSU59hJ-R7ynp1Dm4syy3W0MWmbcPxZIyG96MDFh9KYsxJRT0zHpZ48xmLhD6CE15T0O24LN_4o_ysJNV8I_wtJxhQRmO16yT8aJ_Kf9yhF6IpiIlhIxrSsZMDwT1dHUzG33MZ4HNk8j82EUTzTrGMbbBjcX4NazuD8uOwJpMmtWfE8hxaJ35HDC802cU8dt3uCmrbWWbKUjErgFsOcznLJXqQqrtDqbUK9dykq3s2ZiYdVkNADEaPrFCl3h-soSmlGapSsmUyv_ArjSQ5tfo7OKe0pVHQ")
				.endpoint("https://api.amazon.com/auth/o2/token").build();
		AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider = AWSAuthenticationCredentialsProvider
				.builder().roleArn("arn:aws:iam::312680196323:role/AshishRole").roleSessionName("myrolesessioname")
				.build();
		AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
				.accessKeyId("AKIAURTJRFDRS4XNIUOS").secretKey("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")
				.region("eu-west-1").build();
		SellersApi sellersApi = new SellersApi.Builder().awsAuthenticationCredentials(awsAuthenticationCredentials)
				.lwaAuthorizationCredentials(lwaAuthorizationCredentials)
//				.awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
				.endpoint("https://sellingpartnerapi-eu.amazon.com").build();
		System.out.println(sellersApi.getMarketplaceParticipations().toString());
	}

}
