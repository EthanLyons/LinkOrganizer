package deepdive.cnm.edu.linkorganizer.controller;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import deepdive.cnm.edu.linkorganizer.R;
import deepdive.cnm.edu.linkorganizer.service.GoogleSignInService;


public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    SignInButton signIn = findViewById(R.id.sign_in);
    signIn.setOnClickListener((view) -> signIn());
  }

  @Override
  protected void onStart() {
    super.onStart();
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    if (account != null) {
      GoogleSignInService.getInstance().setAccount(account);
      // TODO Switch to NavActivity.
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      try {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        GoogleSignInAccount account = task.getResult(ApiException.class);
        GoogleSignInService.getInstance().setAccount(account);
        switchToMain();
      } catch (ApiException e) {
        Toast.makeText(this, R.string.login_failure_message, Toast.LENGTH_LONG)
            .show();
      }
    }
  }

  /**
   * Sign in method similar to signOut. Calls sign in.
   */
  private void signIn() {
    Intent intent = GoogleSignInService.getInstance().getClient().getSignInIntent();
    startActivityForResult(intent, LOGIN_REQUEST_CODE);

  }

  /**
   * Switches to main fragment (I think? Don't forget to ask about this one)
   */

  private void switchToMain() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

}
