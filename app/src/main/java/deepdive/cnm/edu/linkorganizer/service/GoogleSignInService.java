package deepdive.cnm.edu.linkorganizer.service;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import deepdive.cnm.edu.linkorganizer.LinkOrganizerApplication;

/**
 * Class used to sign in and talk to Google.
 */
public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder(
        GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .requestId()
        .build();
    client = GoogleSignIn.getClient(LinkOrganizerApplication.getInstance(), options);
  }

  /**
   * Returns the singleton instance of <code>GoogleSignInService</code> for use as needed for
   * signing in or out in the app.
   *
   * @return The singleton instance of this class
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets the google client for further communication with their services.
   *
   * @return Gets google service client.
   */
  public GoogleSignInClient getClient() {
    return client;
  }


  /**
   * Sets the google client the <code>GoogleSignInClient</code> gets.
   *
   * @param client instance of the client
   */
  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  /**
   * Talks to google and takes the information about an instance of an account.
   *
   * @return Gets specific google account instance.
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Gets "this" instance of an account and sets it = to account
   *
   * @param account individual account
   */
  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }


}
