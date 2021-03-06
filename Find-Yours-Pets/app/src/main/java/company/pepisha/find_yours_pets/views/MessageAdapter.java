package company.pepisha.find_yours_pets.views;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import company.pepisha.find_yours_pets.R;
import company.pepisha.find_yours_pets.db.message.Message;

public class MessageAdapter extends ArrayAdapter<Message> {

    private LayoutInflater mInflater = null;

    public MessageAdapter(Context context, int textViewResourceId, List<Message> objects) {
        super(context, textViewResourceId, objects);
        mInflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View messageView = null;

        if (convertView != null) {
            messageView = convertView;
        } else {
            messageView = mInflater.inflate(R.layout.message_layout, null);
        }

        TextView authorName = (TextView) messageView.findViewById(R.id.authorName);
        TextView animalName = (TextView) messageView.findViewById(R.id.animalName);
        TextView messageDate = (TextView) messageView.findViewById(R.id.messageDate);

        Message message = getItem(position);
        authorName.setText(message.getNickname());
        animalName.setText(message.getAnimalName());
        messageDate.setText(message.getDateMessage());

        if (!message.isMessageRead()) {
            setMessageUnread(messageView);
        } else {
            setMessageRead(messageView);
        }

        return messageView;
    }

    public void setMessageRead(View messageView) {
        ImageView icon = (ImageView) messageView.findViewById(R.id.messageIcon);
        TextView authorName = (TextView) messageView.findViewById(R.id.authorName);
        TextView animalName = (TextView) messageView.findViewById(R.id.animalName);
        TextView messageDate = (TextView) messageView.findViewById(R.id.messageDate);

        icon.setImageBitmap(null);
        authorName.setTypeface(Typeface.SERIF);
        animalName.setTypeface(Typeface.SERIF);
        messageDate.setTypeface(Typeface.SERIF);
    }

    public void setMessageUnread(View messageView) {
        ImageView icon = (ImageView) messageView.findViewById(R.id.messageIcon);
        TextView authorName = (TextView) messageView.findViewById(R.id.authorName);
        TextView animalName = (TextView) messageView.findViewById(R.id.animalName);
        TextView messageDate = (TextView) messageView.findViewById(R.id.messageDate);

        icon.setImageResource(R.drawable.message);
        authorName.setTypeface(null, Typeface.BOLD);
        animalName.setTypeface(null, Typeface.BOLD);
        messageDate.setTypeface(null, Typeface.BOLD);
    }
}
