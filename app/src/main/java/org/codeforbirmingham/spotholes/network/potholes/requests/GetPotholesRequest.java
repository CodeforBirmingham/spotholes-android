package org.codeforbirmingham.spotholes.network.potholes.requests;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import org.codeforbirmingham.spotholes.SpotholesApplication;
import org.codeforbirmingham.spotholes.network.potholes.PotholeApiService;

import io.realm.Realm;

/**
 * @author @justinharrison
 */
public class GetPotholesRequest extends RetrofitSpiceRequest<Void, PotholeApiService> {

    public GetPotholesRequest() {
        super(Void.class, PotholeApiService.class);
    }

    @Override
    public Void loadDataFromNetwork() throws Exception {
        Realm realm = SpotholesApplication.getRealm();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(getService().getPotholes());
        realm.commitTransaction();
        return null;
    }
}