package com.example.cookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.example.cookingapp.Interface.ApiInterface;
import com.example.cookingapp.model.Post;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThemMonMoiActivity extends AppCompatActivity {
    private static final String TAG = "Upload @@@";
    ImageView imageView1, imageView2, imageView3, imageView4;
    private Button btnLuu,btnlensong;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;

    TextView tv_api;

    Uri contentURI1, contentURI2, contentURI3, contentURI4;
    String path1, path2, path3, path4;
    String anh1, anh2, anh3, anh4;
    String tendangnhap;
    String tenloai;
    String tenmon;
    String congthuclam;
    String tgnau;
    String dokho;
    String anhmonlvo;
    String tennguyenlieu1;
    String khoiluong1;
    String tennguyenlieu2;
    String khoiluong2;
    String tennguyenlieu3;
    String khoiluong3;
    String tennguyenlieu4;
    String khoiluong4;
    String cachlam;
    String anhcachlam1;
    String anhcachlam2;
    String anhcachlam3;
    String tenuser;

    int clickImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mon);

        SharedPreferences pref = getSharedPreferences("USERNAME", MODE_PRIVATE);
        tenuser = pref.getString("username", "");
        SharedPreferences pref1 = getSharedPreferences("LINK1", MODE_PRIVATE);
        anh1 = pref1.getString("link1", "");
        SharedPreferences pref2 = getSharedPreferences("LINK2", MODE_PRIVATE);
        anh2 = pref2.getString("link2", "");
        SharedPreferences pref3 = getSharedPreferences("LINK3", MODE_PRIVATE);
        anh3 = pref3.getString("link3", "");
        SharedPreferences pref4 = getSharedPreferences("LINK4", MODE_PRIVATE);
        anh4 = pref4.getString("link4", "");

        EditText edtTenMon = findViewById(R.id.tenmon);
        EditText edtLoaiMon = findViewById(R.id.loaimon);
        EditText edtThoiGianNau = findViewById(R.id.edttgn);
        EditText edtDoKho = findViewById(R.id.edtdokho);
        EditText edtMota = findViewById(R.id.mota);
        EditText edtNguyenLieu1 = findViewById(R.id.edtnl);
        EditText edtKhoiLuong1 = findViewById(R.id.edtkl);
        EditText edtNguyenLieu2 = findViewById(R.id.edtnl2);
        EditText edtKhoiLuong2 = findViewById(R.id.edtkl2);
        EditText edtNguyenLieu3 = findViewById(R.id.edtnl3);
        EditText edtKhoiLuong3 = findViewById(R.id.edtkl3);
        EditText edtNguyenLieu4 = findViewById(R.id.edtnl4);
        EditText edtKhoiLuong4 = findViewById(R.id.edtkl4);
        EditText edtCachLam = findViewById(R.id.edtnl2);
        imageView1 = findViewById(R.id.anhdang);
        imageView2 = findViewById(R.id.ivacl1);
        imageView3 = findViewById(R.id.ivacl2);
        imageView4 = findViewById(R.id.ivacl3);

        TextView tvnl2 = findViewById(R.id.tvnl2);
        TextView tvnl3 = findViewById(R.id.tvnl3);
        TextView tvnl4 = findViewById(R.id.tvnl4);
        TextView btnthemnl = findViewById(R.id.btnthemnl);
        TextView btnthemnl2 = findViewById(R.id.btnthemnl2);
        TextView btnthemnl3 = findViewById(R.id.btnthemnl3);




        btnLuu = findViewById(R.id.btnluu);
        btnlensong = findViewById(R.id.btnlensong);



        requestMultiplePermissions();


         tendangnhap = tenuser;
         tenloai = edtLoaiMon.getText().toString();
         tenmon = edtTenMon.getText().toString();
         congthuclam = edtMota.getText().toString();
         tgnau = edtThoiGianNau.getText().toString();
         dokho = edtDoKho.getText().toString();
         anhmonlvo = anh1;
         tennguyenlieu1 = edtNguyenLieu1.getText().toString();
         khoiluong1 = edtKhoiLuong1.getText().toString();
         tennguyenlieu2 = edtNguyenLieu2.getText().toString();
         khoiluong2 = edtKhoiLuong2.getText().toString();
         tennguyenlieu3 = edtNguyenLieu3.getText().toString();
         khoiluong3 = edtKhoiLuong3.getText().toString();
         tennguyenlieu4 = edtNguyenLieu4.getText().toString();
         khoiluong4 = edtKhoiLuong4.getText().toString();
         cachlam = edtCachLam.getText().toString();
         anhcachlam1 = anh2;
         anhcachlam2 = anh3;
         anhcachlam3 = anh4;




        edtNguyenLieu2.setVisibility(View.GONE);
        edtKhoiLuong2.setVisibility(View.GONE);
        tvnl2.setVisibility(View.GONE);
        btnthemnl2.setVisibility(View.GONE);


        edtNguyenLieu3.setVisibility(View.GONE);
        edtKhoiLuong3.setVisibility(View.GONE);
        tvnl3.setVisibility(View.GONE);
        btnthemnl3.setVisibility(View.GONE);

        edtNguyenLieu4.setVisibility(View.GONE);
        edtKhoiLuong4.setVisibility(View.GONE);
        tvnl4.setVisibility(View.GONE);

        btnthemnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNguyenLieu2.setVisibility(View.VISIBLE);
                edtKhoiLuong2.setVisibility(View.VISIBLE);
                tvnl2.setVisibility(View.VISIBLE);
                btnthemnl2.setVisibility(View.VISIBLE);
            }
        });
        btnthemnl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNguyenLieu3.setVisibility(View.VISIBLE);
                edtKhoiLuong3.setVisibility(View.VISIBLE);
                tvnl3.setVisibility(View.VISIBLE);
                btnthemnl3.setVisibility(View.VISIBLE);
            }
        });
        btnthemnl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNguyenLieu4.setVisibility(View.VISIBLE);
                edtKhoiLuong4.setVisibility(View.VISIBLE);
                tvnl4.setVisibility(View.VISIBLE);
            }
        });

        initConfig();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickImage = 1;
                showPictureDialog();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickImage = 2;
                showPictureDialog();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickImage = 3;
                showPictureDialog();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickImage = 4;
                showPictureDialog();
            }
        });

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaManager.get().upload(contentURI1).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {
                        Log.d(TAG, "onStart: " + " started");
                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {
                        Log.d(TAG, "onStart: " + " uploading");
                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        path1 = (String) resultData.get("url");
                        SharedPreferences pref = getSharedPreferences("LINK1", MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("link1",path1);
                        editor.commit();
                        Log.d(TAG, "onStart: " + " unsuccess  " + path1);
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }
                }).dispatch();


                MediaManager.get().upload(contentURI2).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {
                        Log.d(TAG, "onStart: " + " started");
                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {
                        Log.d(TAG, "onStart: " + " uploading");
                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        path2 = (String) resultData.get("url");
                        SharedPreferences pref = getSharedPreferences("LINK2", MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("link2",path2);
                        editor.commit();

                        Log.d(TAG, "onStart: " + " unsuccess  " + path2);
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }
                }).dispatch();


                MediaManager.get().upload(contentURI3).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {
                        Log.d(TAG, "onStart: " + " started");
                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {
                        Log.d(TAG, "onStart: " + " uploading");
                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        path3 = (String) resultData.get("url");
                        SharedPreferences pref = getSharedPreferences("LINK3", MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("link3",path3);
                        editor.commit();
                        Log.d(TAG, "onStart: " + " unsuccess   " + path3);
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }
                }).dispatch();


                MediaManager.get().upload(contentURI4).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {
                        Log.d(TAG, "onStart: " + " started");
                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {
                        Log.d(TAG, "onStart: " + " uploading");
                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        path4 = (String) resultData.get("url");
                        SharedPreferences pref = getSharedPreferences("LINK4", MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("link4",path4);
                        editor.commit();
                        Log.d(TAG, "onStart: " + " unsuccess   " + path4);
                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        Log.d(TAG, "onStart: " + error);
                    }
                }).dispatch();


            }
        });

        btnlensong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post(
                        tenloai,
                        tenmon,
                        congthuclam,
                        tgnau,
                        dokho,
                        anhmonlvo,
                        tendangnhap,
                        tennguyenlieu1,
                        khoiluong1,
                        tennguyenlieu2,
                        khoiluong2,
                        tennguyenlieu3,
                        khoiluong3,
                        tennguyenlieu4,
                        khoiluong4,
                        cachlam,
                        anhcachlam1,
                        anhcachlam2,
                        anhcachlam3);
                ApiInterface.apiInterface.sendPosts(post).enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Toast.makeText(ThemMonMoiActivity.this, "call api success", Toast.LENGTH_SHORT).show();

                        Post postResult = response.body();
                        if (postResult != null){
                            tv_api.setText(postResult.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(ThemMonMoiActivity.this, "call api error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }


    private void initConfig() {
        Map config = new HashMap();
        config.put("cloud_name", "doluugxhe");
        config.put("api_key", "531346586926927");
        config.put("api_secret", "4Jfm_W31t0SMm_BDcL2KkSVlwKw");
//        config.put("secure", true);
        MediaManager.init(this, config);
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        switch (clickImage) {
            case 1:
                if (requestCode == GALLERY) {
                    if (data != null) {
                        contentURI1 = data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI1);
                            String path = saveImage(bitmap);
                            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                            imageView1.setImageBitmap(bitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (requestCode == CAMERA) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageView1.setImageBitmap(thumbnail);
                    saveImage(thumbnail);
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                }

                break;
            case 2:
                if (requestCode == GALLERY) {
                    if (data != null) {
                        contentURI2 = data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI2);
                            String path = saveImage(bitmap);
                            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                            imageView2.setImageBitmap(bitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (requestCode == CAMERA) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageView2.setImageBitmap(thumbnail);
                    saveImage(thumbnail);
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 3:
                if (requestCode == GALLERY) {
                    if (data != null) {
                        contentURI3 = data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI3);
                            String path = saveImage(bitmap);
                            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                            imageView3.setImageBitmap(bitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (requestCode == CAMERA) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageView3.setImageBitmap(thumbnail);
                    saveImage(thumbnail);
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                }
                break;
            case 4:
                if (requestCode == GALLERY) {
                    if (data != null) {
                        contentURI4 = data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI4);
                            String path = saveImage(bitmap);
                            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                            imageView4.setImageBitmap(bitmap);

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }

                } else if (requestCode == CAMERA) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageView4.setImageBitmap(thumbnail);
                    saveImage(thumbnail);
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    private void requestMultiplePermissions() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

}