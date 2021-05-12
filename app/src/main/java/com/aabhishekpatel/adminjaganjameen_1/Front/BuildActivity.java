package com.aabhishekpatel.adminjaganjameen_1.Front;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aabhishekpatel.adminjaganjameen_1.MainActivity;
import com.aabhishekpatel.adminjaganjameen_1.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;

public class BuildActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST_CODE = 1;

    private EditText buildname , buildprice , buildphone;
    private Button chooseimage, upload;
    private ImageView uploaded_image;

    Uri imageURI;

    String myUrl = "";

    StorageReference storageReference;
    DatabaseReference databaseReference;
    StorageTask uploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        buildname = (EditText) findViewById(R.id.buildname);
        buildprice = (EditText) findViewById(R.id.buildprice);
        buildphone = (EditText) findViewById(R.id.buildphone);
        chooseimage = (Button) findViewById(R.id.chooseimage);
        upload = (Button) findViewById(R.id.upload);
        uploaded_image = findViewById(R.id.uploaded_image);

        storageReference = FirebaseStorage.getInstance().getReference("Build");

        chooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
                CropImage.activity()
                        .setAspectRatio(3,2)
                        .start(BuildActivity.this);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });
    }
    private void uploadImage() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Posting");
        progressDialog.show();

        if (imageURI != null){
            final StorageReference filereference = storageReference.child(System.currentTimeMillis()
                    + "."+ getFileExtension(imageURI));

            uploadTask = filereference.putFile(imageURI);
            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isComplete()){
                        throw task.getException();
                    }
                    return filereference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){
                        Uri downloadUri = task.getResult();
                        myUrl = downloadUri.toString();

                        databaseReference = FirebaseDatabase.getInstance().getReference("Build");

                        String postid = databaseReference.push().getKey();

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("buildid",postid);
                        hashMap.put("buildimage1",myUrl);
                        hashMap.put("buildimage2",myUrl);
                        hashMap.put("buildimage3",myUrl);
                        hashMap.put("buildimage4",myUrl);
                        hashMap.put("buildname",buildname.getText().toString());
                        hashMap.put("buildprice",buildprice.getText().toString());
                        hashMap.put("buildphone",buildphone.getText().toString());

                        databaseReference.child(postid).setValue(hashMap);

                        progressDialog.dismiss();

                        startActivity(new Intent(BuildActivity.this, MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(BuildActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(BuildActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(this, "No image Selected.!", Toast.LENGTH_SHORT).show();
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK
                && data != null && data.getData() != null)
        {
            imageURI = data.getData();
            uploaded_image.setImageURI(imageURI);
        }
    }


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }
}
