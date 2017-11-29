import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("k")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("z")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("v")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("m")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("b")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -7960597093973813L
   )
   @Export("lastSerialize")
   long lastSerialize;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Player.configsIndex.fileCount(19)];
      this.varcstrings = new String[Player.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class250 var3 = (class250)class250.field3388.get((long)var1);
         class250 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class250.field3387.getConfigData(19, var1);
            var3 = new class250();
            if(var4 != null) {
               var3.method4468(new Buffer(var4));
            }

            class250.field3388.put(var3, (long)var1);
            var2 = var3;
         }

         this.varcSerials[var1] = var2.field3389;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class251 var6 = (class251)class251.field3391.get((long)var1);
         class251 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class251.field3392.getConfigData(15, var1);
            var6 = new class251();
            if(var4 != null) {
               var6.method4486(new Buffer(var4));
            }

            class251.field3391.put(var6, (long)var1);
            var5 = var6;
         }

         this.varcstringSerials[var1] = var5.field3390;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1707831943"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1653280277"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)V",
      garbageValue = "585"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1601921729"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-780792805"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZB)Ldt;",
      garbageValue = "-100"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class46.getPreferencesFile("2", class36.field483.name, var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "860755319"
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
               var2 += 2 + AbstractSoundSystem.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = ServerPacket.currentTimeMs();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1712708639"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label185: {
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
                     break label185;
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
            break label185;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2059171857"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < ServerPacket.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-58"
   )
   public static void method1883(int var0, int var1) {
      Varbit var2 = class61.method1089(var0);
      int var3 = var2.configId;
      int var4 = var2.leastSignificantBit;
      int var5 = var2.mostSignificantBit;
      int var6 = class218.varpsMasks[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class218.widgetSettings[var3] = class218.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "34"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "643563451"
   )
   static final void method1881() {
      Client.field908 = 0;
      int var0 = (class181.localPlayer.x >> 7) + IndexDataBase.baseX;
      int var1 = (class181.localPlayer.y >> 7) + Occluder.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field908 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field908 = 1;
      }

      if(Client.field908 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field908 = 0;
      }

   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lhx;B)Z",
      garbageValue = "-16"
   )
   static final boolean method1877(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = CacheFile.method2441(var0, var1);
            int var3 = var0.field2822[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
