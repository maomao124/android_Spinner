package mao.android_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Spinner spinner = findViewById(R.id.Spinner2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_select,
                new String[]
                        {
                                "选项1",
                                "选项2",
                                "选项3",
                                "选项4",
                                "选项5",
                                "选项6",
                                "选项7"
                        }
        );
        spinner.setPrompt("请选择");
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                toastShow("当前选择的是第" + (position + 1) + "个");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                toastShow("取消选择");
            }
        });
    }

    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}