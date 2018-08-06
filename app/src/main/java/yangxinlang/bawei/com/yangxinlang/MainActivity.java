package yangxinlang.bawei.com.yangxinlang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.fynn.fluidlayout.FluidLayout;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TagFlowLayout lishi;
    private FluidLayout remen;
        private List<String> list;
//
//    private List<String> list2;

    private String rm[] = {"流感", "咳嗽", "过敏", "发烧", "感冒", "湿疹", "便秘",
            "痔疮", "协和", "鼻炎", "失眠", "痛风", "上火", "脚气", "抑郁症", "性欲", "乳腺增生", "头晕", "腰痛",};
    private TextView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lishi = findViewById(R.id.lishi);
        remen = findViewById(R.id.remen);
        close = findViewById(R.id.close);
        list = new ArrayList<>();
        list.add("流感");
        list.add("布洛芬混悬液");
        list.add("鼻炎");
        list.add("布诺芬");
        list.add("对乙醯氨基酚缓释片");
        list.add("上火");
        list.add("氨麻苯美片");
        list.add("失眠");
        list.add("中风");
        final LishiAdapter adapter = new LishiAdapter(list);
        lishi.setAdapter(adapter);
         close.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 list.clear();
                 adapter.notifyDataChanged();
             }
         });

//        list2 = new ArrayList<>();
//        for (int i = 0; i < lisi.length; i++) {
//            FluidLayout.LayoutParams layoutParams =
//                    new FluidLayout.LayoutParams
//                            (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(12, 12, 12, 12);
//            TextView textView = new TextView(this);
//            textView.setText(lisi[i]);
//
//        lishi.addView(textView,layoutParams);
//        }
        for (int i = 0; i < rm.length; i++) {
            FluidLayout.LayoutParams layoutParams =
                    new FluidLayout.LayoutParams
                            (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(12, 12, 12, 12);
            TextView textView = new TextView(this);
            textView.setText(rm[i]);

            remen.addView(textView,layoutParams);
        }
    }


     class LishiAdapter extends TagAdapter<String>{
         public LishiAdapter(List<String> datas) {
             super(datas);
         }

         @Override
         public View getView(FlowLayout parent, int position, String s) {
             TextView textView = new TextView(MainActivity.this);
             textView.setText(s);
             return textView;
         }
     }
}
