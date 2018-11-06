package com.ak.user.expenseslist.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ak.user.expenseslist.DataBase.DbAdapter;
import com.ak.user.expenseslist.R;
import com.ak.user.expenseslist.enums.OperationType;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OperationsAdapter extends CursorAdapter
{
    private Context context;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("kk:mm");

    private Calendar calendar = Calendar.getInstance();



    public OperationsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    private LayoutInflater layoutInflater;

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.listview_row_operation, viewGroup, false);

        ViewHolder holder = new ViewHolder();

        holder.source = (TextView) view.findViewById(R.id.txt_oper_source);
        holder.date = (TextView) view.findViewById(R.id.txt_oper_date);
        holder.image = (ImageView) view.findViewById(R.id.img_source);
        holder.time = (TextView) view.findViewById(R.id.txt_oper_time);
        holder.amount = (TextView) view.findViewById(R.id.txt_oper_amount);
        holder.type = (TextView) view.findViewById(R.id.txt_oper_type);
        holder.currency = (TextView) view.findViewById(R.id.txt_oper_currency);

        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder holder = (ViewHolder) view.getTag();


        holder.amount.setText(cursor.getString(cursor.getColumnIndex(DbAdapter.ALIAS_AMOUNT)));
        holder.source.setText(cursor.getString(cursor.getColumnIndex(DbAdapter.ALIAS_SOURCE)));
        holder.type.setText(cursor.getString(cursor.getColumnIndex(DbAdapter.ALIAS_TYPE)));
        holder.currency.setText(cursor.getString(cursor.getColumnIndex(DbAdapter.ALIAS_CURRENCY)));

        long dateTime = cursor.getLong(cursor.getColumnIndex(DbAdapter.ALIAS_OPERATION_DATETIME));
        calendar.setTimeInMillis(dateTime);

        holder.date.setText(dateFormatter.format(calendar.getTime())+", ");
        holder.time.setText(timeFormatter.format(calendar.getTime()));

        if (cursor.getInt(cursor.getColumnIndex(DbAdapter.ALIAS_TYPE_ID)) == Integer.valueOf(OperationType.INCOME.getId())){
            holder.type.setTextColor(Color.GREEN);
        }else{
            holder.type.setTextColor(Color.RED);
        }
    }

    static class ViewHolder {
        public TextView date;
        public ImageView image;
        public TextView time;
        public TextView amount;
        public TextView source;
        public TextView type;
        public TextView currency;
    }
}
