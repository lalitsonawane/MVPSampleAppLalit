package in.apptonic.mvpsampleapplalit.presenter;

import in.apptonic.mvpsampleapplalit.model.UserInfo;

public class MainPresenter {


    private UserInfo userInfo;
    private View view;


    public MainPresenter(View view){

        this.userInfo = new UserInfo();
        this.view = view;
    }

    public void updateName(String name){

    userInfo.setName(name);
    view.updateUserInfoTextView(userInfo.toString());

    }

    public void updateEmail(String emmail){
        userInfo.setEmail(emmail);
        view.updateUserInfoTextView(userInfo.toString());

    }

    public interface View{


        void updateUserInfoTextView(String info);
        void showProgressbar();
        void hideProgressBar();

    }
}
