import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -1010970585
   )
   static int field1491;
   @ObfuscatedName("v")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("e")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("f")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("x")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -604362085379148825L
   )
   @Export("lastSerialize")
   long lastSerialize;
   @ObfuscatedName("y")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Occluder.configsIndex.fileCount(19)];
      this.varcstrings = new String[Occluder.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class243 var3 = (class243)class243.field3297.get((long)var1);
         class243 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class243.field3298.getConfigData(19, var1);
            var3 = new class243();
            if(var4 != null) {
               var3.method4297(new Buffer(var4));
            }

            class243.field3297.put(var3, (long)var1);
            var2 = var3;
         }

         this.varcSerials[var1] = var2.field3296;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class244 var5 = class47.method710(var1);
         this.varcstringSerials[var1] = var5.field3301;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)Lcn;",
      garbageValue = "1143069235"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class41.getPreferencesFile("2", Client.field1110.field3177, var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-91"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "9034"
   )
   @Export("serialize")
   void serialize() {
      FileOnDisk var1 = this.getVarPrefs(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.varcs.length; ++var4) {
            if(this.varcSerials[var4] && this.varcs[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.varcstrings.length; ++var5) {
            if(this.varcstringSerials[var5] && this.varcstrings[var5] != null) {
               var2 += 2 + VertexNormal.getLength(this.varcstrings[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.varcs.length; ++var6) {
            if(this.varcSerials[var6] && this.varcs[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.varcs[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.varcstrings.length; ++var6) {
            if(this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
               var9.putShort(var6);
               var9.putString(this.varcstrings[var6]);
            }
         }

         var1.write(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var16) {
            ;
         }

      }

      this.changed = false;
      this.lastSerialize = BuildType.currentTimeMs();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label198: {
         try {
            byte[] var2 = new byte[(int)var1.length()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.read(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var5 = var13.readUnsignedByte();
            if(var5 >= 0 && var5 <= 1) {
               int var6 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.varcSerials[var8]) {
                     this.varcs[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label198;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.varcstringSerials[var9]) {
                     this.varcstrings[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label198;
         } finally {
            try {
               var1.close();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   @Export("reset")
   void reset() {
      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         if(!this.varcSerials[var1]) {
            this.varcs[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         if(!this.varcstringSerials[var1]) {
            this.varcstrings[var1] = null;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1148232777"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1833333094"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "611159042"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1933025384"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < BuildType.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ldz;I)V",
      garbageValue = "-1323107068"
   )
   static final void method1835(class121 var0) {
      var0.field1708 = false;
      if(var0.field1706 != null) {
         var0.field1706.field1740 = 0;
      }

      for(class121 var1 = var0.vmethod3913(); var1 != null; var1 = var0.vmethod3895()) {
         method1835(var1);
      }

   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "2120371347"
   )
   static final void method1833(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1000 - Client.field1070) * var5 / 100 + Client.field1070;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1137) {
         var15 = Client.field1137;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1141) {
            var6 = Client.field1141;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4937(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4937(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1143) {
         var15 = Client.field1143;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1140) {
            var6 = Client.field1140;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4937(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4937(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field1138 + (Client.field1017 - Client.field1138) * var5 / 100;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2735(var14, 500, 800, var2, var3);
      }

      Client.field1072 = var0;
      Client.field1145 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-243171894"
   )
   static final String method1836(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "85"
   )
   static void method1834(int var0, String var1) {
      int var2 = class96.field1470;
      int[] var3 = class96.field1468;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != class224.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(222);
               Client.secretPacketBuffer1.method3226(0);
               Client.secretPacketBuffer1.putShortLE(var3[var5]);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(44);
               Client.secretPacketBuffer1.putShortLE(var3[var5]);
               Client.secretPacketBuffer1.method3227(0);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(83);
               Client.secretPacketBuffer1.putShortLE(var3[var5]);
               Client.secretPacketBuffer1.method3226(0);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(142);
               Client.secretPacketBuffer1.method3331(var3[var5]);
               Client.secretPacketBuffer1.method3227(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class202.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
