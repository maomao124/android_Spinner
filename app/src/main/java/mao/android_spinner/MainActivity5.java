package mao.android_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity5 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Spinner spinner = findViewById(R.id.Spinner4);

        int[] iconArray = new int[]
                {
                        R.drawable.ic_launcher_foreground,
                        R.drawable.ic_launcher_foreground,
                        R.drawable.ic_launcher_foreground,
                        R.drawable.ic_launcher_foreground,
                        R.drawable.ic_launcher_foreground,
                        R.drawable.ic_launcher_foreground,
                };

        String[] nameArray = new String[]
                {
                        "选项1",
                        "选项2",
                        "选项3",
                        "选项4",
                        "选项5",
                        "选项6",
                };


        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++)
        {
            Map<String, Object> map = new HashMap<>(2);
            map.put("icon", iconArray[i]);
            map.put("name", nameArray[i]);
            list.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
                R.layout.item_simple,
                new String[]{"icon", "name"},
                new int[]{R.id.iv_icon, R.id.tv_name}
        );


        spinner.setPrompt("请选择");
        spinner.setAdapter(simpleAdapter);
        spinner.setSelection(2);

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