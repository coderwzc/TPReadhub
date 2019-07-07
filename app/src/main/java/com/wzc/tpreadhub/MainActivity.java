package com.wzc.tpreadhub;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navView;
    private  TrendingNewsFragment trendingNewsFragment;
    private  TechNewsFragment techNewsFragment;
    private  DeveloperNewsFragment developerNewsFragment;
    private  BlockchainNewsFragment blockchainNewsFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        navView = findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//让导航按钮显示出来
            actionBar.setHomeAsUpIndicator(R.drawable.menu);//设置一个导航按钮图标
        }
        navView.setCheckedItem(R.id.remen);//将Call菜单项设置为默认选中
        if(trendingNewsFragment==null)
            trendingNewsFragment=new TrendingNewsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,trendingNewsFragment).commitAllowingStateLoss();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Resources resource=getBaseContext().getResources();
                switch (item.getItemId()){
                    case R.id.remen:
                        item.setChecked(true);
                        for(int i=0;i<navView.getMenu().size();i++){
                            MenuItem tempMenuItem=navView.getMenu().getItem(i);
                            if (tempMenuItem.getItemId()!=item.getItemId()) {
                                tempMenuItem.setChecked(false);
                            }
                        }
                        ColorStateList csl=resource.getColorStateList(R.color.navigation_menu_item_color);
                        navView.setItemTextColor(csl);
                        if(trendingNewsFragment==null)
                            trendingNewsFragment=new TrendingNewsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,trendingNewsFragment).commitAllowingStateLoss();
                        break;
                    case R.id.keji:
                        item.setChecked(true);
                        for(int i=0;i<navView.getMenu().size();i++){
                            MenuItem tempMenuItem=navView.getMenu().getItem(i);
                            if (tempMenuItem.getItemId()!=item.getItemId()) {
                                tempMenuItem.setChecked(false);
                            }
                        }
                        ColorStateList csl2=resource.getColorStateList(R.color.navigation_menu_item_color);
                        navView.setItemTextColor(csl2);
                        if(techNewsFragment==null)
                            techNewsFragment=new TechNewsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,techNewsFragment).commitAllowingStateLoss();
                        break;
                    case R.id.kaifazhe:
                        item.setChecked(true);
                        for(int i=0;i<navView.getMenu().size();i++){
                            MenuItem tempMenuItem=navView.getMenu().getItem(i);
                            if (tempMenuItem.getItemId()!=item.getItemId()) {
                                tempMenuItem.setChecked(false);
                            }
                        }
                        ColorStateList csl3=resource.getColorStateList(R.color.navigation_menu_item_color);
                        navView.setItemTextColor(csl3);
                        if(developerNewsFragment==null)
                            developerNewsFragment = new DeveloperNewsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, developerNewsFragment).commitAllowingStateLoss();
                        break;
                    case R.id.qukuailian:
                        item.setChecked(true);
                        for(int i=0;i<navView.getMenu().size();i++){
                            MenuItem tempMenuItem=navView.getMenu().getItem(i);
                            if (tempMenuItem.getItemId()!=item.getItemId()) {
                                tempMenuItem.setChecked(false);
                            }
                        }
                        ColorStateList csl4=resource.getColorStateList(R.color.navigation_menu_item_color);
                        navView.setItemTextColor(csl4);
                        if(blockchainNewsFragment==null)
                            blockchainNewsFragment = new BlockchainNewsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, blockchainNewsFragment).commitAllowingStateLoss();
                        break;
                    default:
                }
                drawerLayout.closeDrawers();//关闭滑动菜单
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (android.R.id.home == item.getItemId()) {
            drawerLayout.openDrawer(navView);
        }
        return super.onOptionsItemSelected(item);
    }
}