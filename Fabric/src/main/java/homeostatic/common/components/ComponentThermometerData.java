package homeostatic.common.components;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

import homeostatic.common.capabilities.Thermometer;
import homeostatic.common.temperature.ThermometerInfo;
import homeostatic.network.ThermometerData;

public class ComponentThermometerData extends Thermometer implements Component, AutoSyncedComponent {

    @Override
    public void readFromNbt(CompoundTag tag) {
        this.read(tag.getCompound("ThermometerData"));
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.put("ThermometerData", this.write());
    }

    @Override
    public void writeSyncPacket(FriendlyByteBuf buf, ServerPlayer recipient) {
        ThermometerData thermometerData = new ThermometerData(new ThermometerInfo(hasThermometer()));

        thermometerData.toBytes(buf);
    }

    @Override
    public void applySyncPacket(FriendlyByteBuf buf) {
        ThermometerData thermometerData = new ThermometerData(buf);

        this.setHasThermometer(thermometerData.hasThermometer);
    }

}
