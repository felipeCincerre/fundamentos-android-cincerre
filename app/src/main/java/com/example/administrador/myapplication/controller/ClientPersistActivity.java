package com.example.administrador.myapplication.controller;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.myapplication.R;
import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.ClientAddress;
import com.example.administrador.myapplication.model.services.CepService;
import com.example.administrador.myapplication.util.FormHelper;

import java.util.concurrent.ExecutionException;

/**
 * Created by Administrador on 21/07/2015.
 */
public class ClientPersistActivity extends AppCompatActivity {
    public static String CLIENT_PARAM = "CLIENT_PARAM";
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextPhone;
    private EditText editTextTipoDeLogradouro;
    private EditText editTextLogradouro;
    private EditText editTextBairro;
    private EditText editTextCidade;
    private EditText editTextEstado;
    private EditText editTextCep;
    private Button buttonFind;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persist_client);
        bindFields();
        getParameters();
    }

    private void getParameters() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            client = (Client) extras.getParcelable(CLIENT_PARAM);
            if (client == null) {
                throw new IllegalArgumentException();
            }
            bindForm(client);
        }
    }

    private void bindFields() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextCep = (EditText) findViewById(R.id.editTextCep);
        editTextTipoDeLogradouro = (EditText) findViewById(R.id.editTextTipoDeLogradouro);
        editTextLogradouro = (EditText) findViewById(R.id.editTextLogradouro);
        editTextBairro = (EditText) findViewById(R.id.editTextBairro);
        editTextEstado = (EditText) findViewById(R.id.editTextEstado);
        editTextCidade = (EditText) findViewById(R.id.editTextCidade);
        bindButtonFindCep();
    }

    private void bindButtonFindCep() {
        buttonFind = (Button) findViewById(R.id.buttonFind);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetAddressByCep().execute(editTextCep.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client_persist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuSave) {
            if (FormHelper.requireValidate(ClientPersistActivity.this, editTextName, editTextAge, editTextPhone)) {
                bindClient();
                client.save();
                ClientPersistActivity.this.finish();
                Toast.makeText(ClientPersistActivity.this, ClientPersistActivity.this.getString(R.string.success), Toast.LENGTH_LONG).show();
                //Intent goToMainActivity = new Intent(ClientPersistActivity.this, ClientListActivity.class);
                //startActivity(goToMainActivity);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindClient() {
        if (client == null) {
            client = new Client();
        }
        client.setName(editTextName.getText().toString());
        client.setAge(Integer.valueOf(editTextAge.getText().toString()));
        client.setPhone(editTextPhone.getText().toString());
        client.setCep(editTextCep.getText().toString());
        client.setTipoDeLogradouro(editTextTipoDeLogradouro.getText().toString());
        client.setLogradouro(editTextLogradouro.getText().toString());
        client.setBairro(editTextBairro.getText().toString());
        client.setCidade(editTextCidade.getText().toString());
        client.setEstado(editTextEstado.getText().toString());
    }

    private void bindForm(Client client) {
        editTextName.setText(client.getName());
        editTextAge.setText(client.getAge().toString());
        editTextPhone.setText(client.getPhone());
        editTextCep.setText(client.getCep());
        editTextTipoDeLogradouro.setText(client.getTipoDeLogradouro());
        editTextLogradouro.setText(client.getLogradouro());
        editTextBairro.setText(client.getBairro());
        editTextCidade.setText(client.getCidade());
        editTextEstado.setText(client.getEstado());
    }

    private class GetAddressByCep extends AsyncTask<String, Void, ClientAddress> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(ClientPersistActivity.this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.show();
        }

        @Override
        protected ClientAddress doInBackground(String... params) {
            return CepService.getAddressBy(params[0]);
        }

        @Override
        protected void onPostExecute(ClientAddress clientAddress) {
            editTextCep.setText(clientAddress.getCep());
            editTextTipoDeLogradouro.setText(clientAddress.getTipoDeLogradouro());
            editTextLogradouro.setText(clientAddress.getLogradouro());
            editTextBairro.setText(clientAddress.getBairro());
            editTextCidade.setText(clientAddress.getCidade());
            editTextEstado.setText(clientAddress.getEstado());
            progressDialog.dismiss();
        }
    }
}
