package me.nullnet.voxelclient.packets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record AtlasPayloadPacket(String command) implements class_8710 {
   public static final class_9139<class_2540, AtlasPayloadPacket> CODEC = class_8710.method_56484(AtlasPayloadPacket::write, AtlasPayloadPacket::new);
   public static final class_9154<AtlasPayloadPacket> ID = new class_9154(class_2960.method_60655("atlas", "out"));

   private AtlasPayloadPacket(class_2540 buf) {
      this(buf.method_19772());
   }

   public AtlasPayloadPacket(String command) {
      this.command = command;
   }

   public void write(class_2540 buf) {
      try {
         ByteArrayOutputStream stream = new ByteArrayOutputStream();
         ObjectOutputStream oStream = new ObjectOutputStream(stream);
         oStream.writeUTF("commandBungee");
         oStream.writeObject(this.command);
         buf.method_52983(stream.toByteArray());
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   public class_9154<AtlasPayloadPacket> method_56479() {
      return ID;
   }

   public String command() {
      return this.command;
   }
}
