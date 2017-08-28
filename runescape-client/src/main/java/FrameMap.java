import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ei")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -512648019
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 414095519
   )
   @Export("count")
   int count;
   @ObfuscatedName("a")
   @Export("types")
   int[] types;
   @ObfuscatedName("r")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lii;II)Z",
      garbageValue = "-1264967661"
   )
   static boolean method2710(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4209(var1);
      if(var2 == null) {
         return false;
      } else {
         GraphicsObject.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-766202473"
   )
   static long method2707() {
      try {
         URL var0 = new URL(class86.method1709("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lhx;Lix;IIZI)V",
      garbageValue = "-1695262621"
   )
   static final void method2709(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         class24.method202(var7, Friend.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "25"
   )
   static void method2708(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = Varcs.method1849(var1, var2);
      if(var5 != null) {
         if(var5.field2701 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field861 = var0;
            var6.field865 = var4;
            var6.field864 = var5.field2701;
            class153.method3002(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class165.method3153(var5);
         }

         if(var10) {
            int var8 = Coordinates.getWidgetConfig(var5);
            int var9 = var0 - 1;
            boolean var7 = 0 != (var8 >> var9 + 1 & 1);
            if(var7) {
               if(var0 == 1) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_250);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 2) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_7);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 3) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_171);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 4) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_146);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 5) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_1);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 6) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_105);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 7) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_173);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 8) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_196);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 9) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_142);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 10) {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_221);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

            }
         }
      }
   }
}
