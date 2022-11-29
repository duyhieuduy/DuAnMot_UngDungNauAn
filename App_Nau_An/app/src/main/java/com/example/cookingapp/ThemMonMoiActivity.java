package com.example.cookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.example.cookingapp.dao.DangBaiDao;
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

public class ThemMonMoiActivity extends AppCompatActivity {
    private static final String TAG = "Upload @@@";
    ImageView imageView1, imageView2, imageView3, imageView4;
    private Button btnLuu, btnLuuAnh;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;

    Uri contentURI1, contentURI2, contentURI3, contentURI4;
    String path1, path2, path3, path4;

    int clickImage;
    DangBaiDao baiDangDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon_moi);

        EditText edtTenMon = findViewById(R.id.edtTenMon);
        EditText edtLoaiMon = findViewById(R.id.edtLoaiMon);
        EditText edtThoiGianNau = findViewById(R.id.edtThoiGianNau);
        EditText edtDoKho = findViewById(R.id.edtDoKho);
        EditText edtNguyenLieu1 = findViewById(R.id.edtNguyenLieu1);
        EditText edtKhoiLuong1 = findViewById(R.id.edtKhoiLuong1);
        EditText edtNguyenLieu2 = findViewById(R.id.edtNguyenLieu2);
        EditText edtKhoiLuong2 = findViewById(R.id.edtKhoiLuong2);
        EditText edtNguyenLieu3 = findViewById(R.id.edtNguyenLieu3);
        EditText edtKhoiLuong3 = findViewById(R.id.edtKhoiLuong3);
        EditText edtNguyenLieu4 = findViewById(R.id.edtNguyenLieu4);
        EditText edtKhoiLuong4 = findViewById(R.id.edtKhoiLuong4);
        EditText edtCachLam = findViewById(R.id.edtCachLam);

        btnLuu = findViewById(R.id.btnLuu);
        btnLuuAnh = findViewById(R.id.btnLuuAnh);

        imageView1 = findViewById(R.id.imgAnhMon);
        imageView2 = findViewById(R.id.imgAnhCachLam1);
        imageView3 = findViewById(R.id.imgAnhCachLam2);
        imageView4 = findViewById(R.id.imgAnhCachLam3);
        requestMultiplePermissions();


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

        btnLuuAnh.setOnClickListener(new View.OnClickListener() {
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
                        Log.d(TAG, "onStart: " + " unsuccess" + path1);
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
                        Log.d(TAG, "onStart: " + " unsuccess" + path2);
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
                        Log.d(TAG, "onStart: " + " unsuccess" + path3);
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
                        Log.d(TAG, "onStart: " + " unsuccess" + path4);
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

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



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