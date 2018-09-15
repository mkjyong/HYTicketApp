package module.nrlwallet.com.sdktest;

import android.app.Activity;
import android.os.Bundle;

import org.json.JSONArray;

import module.nrlwallet.com.nrlwalletsdk.Coins.NRLBitcoin;
import module.nrlwallet.com.nrlwalletsdk.Coins.NRLEthereum;
import module.nrlwallet.com.nrlwalletsdk.Coins.NRLLite;
import module.nrlwallet.com.nrlwalletsdk.Coins.NRLNeo;
import module.nrlwallet.com.nrlwalletsdk.Coins.NRLStellar;
import module.nrlwallet.com.nrlwalletsdk.Utils.GenerateMnemonic;
import module.nrlwallet.com.nrlwalletsdk.Language.English;
import module.nrlwallet.com.nrlwalletsdk.Utils.MnemonicToSeed;
import module.nrlwallet.com.nrlwalletsdk.Utils.Util;
import module.nrlwallet.com.nrlwalletsdk.abstracts.NRLCallback;

public class MainActivity extends Activity {

    private String strMnemonic;
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuilder sb = new StringBuilder();
        //
        new GenerateMnemonic(English.INSTANCE).createMnemonic(sb::append);

        this.getEthereumWallet(strMnemonic);//DONE

    }

    private void getEthereumWallet(String strMnemonic) {
        byte[] bseed = new MnemonicToSeed().calculateSeedByte(strMnemonic, "");
        String seed = new MnemonicToSeed().calculateSeed(strMnemonic, "");

        NRLEthereum nrlEthereum = new NRLEthereum(bseed, strMnemonic);

        nrlEthereum.getBalance(new NRLCallback() {
            @Override
            public void onFailure(Throwable t) {

            }
            @Override
            public void onResponse(String response) {
                System.out.println("************----------- ETH Balance     : " + response);

            }
            @Override
            public void onResponseArray(JSONArray jsonArray) {

            }
        });


        nrlEthereum.getTransactions(new NRLCallback() {
            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onResponse(String response) {

            }

            @Override
            public void onResponseArray(JSONArray jsonArray) {

            }
        });

        //amount, toAddress, memo, fee, callback
//        nrlEthereum.createTransaction("500000000000000", "0x9aFEE7Af06290771F589381730312939c2657239", "", 0.00001, new NRLCallback(){
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//            @Override
//            public void onResponse(String response) {
//                System.out.println("************----------- ETH Balance     : " + response);
//
//            }
//            @Override
//            public void onResponseArray(JSONArray jsonArray) {
//
//            }
//        });
    }

}
