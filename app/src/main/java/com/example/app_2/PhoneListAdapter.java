package com.example.app_2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_2.databinding.PhoneItemBinding;
import com.example.app_2.model.Phone;

import java.util.List;

public class PhoneListAdapter extends RecyclerView.Adapter<PhoneListAdapter.PhoneItemViewHolder> {

    private LayoutInflater inflater;
    private List<Phone> phones;

    public PhoneListAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhoneItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PhoneItemViewHolder(PhoneItemBinding.inflate(this.inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneItemViewHolder holder, int position) {
        if(this.phones != null){
            Phone currentPhone = this.phones.get(position);
            holder.binding.tvManufacturer.setText(currentPhone.getManufacturer());
            holder.binding.tvModel.setText(currentPhone.getModel());

        }




    }

    @Override
    public int getItemCount() {
        return phones != null ? phones.size() : 0;
    }

    public static class PhoneItemViewHolder extends RecyclerView.ViewHolder {
        private final PhoneItemBinding binding;

        public PhoneItemViewHolder(@NonNull PhoneItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
