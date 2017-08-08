import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("v")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("k")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("w")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 750734539116371031L
   )
   @Export("lastSerialize")
   long lastSerialize;
   @ObfuscatedName("y")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("g")
   @Export("varcSerials")
   boolean[] varcSerials;

   Varcs() {
      this.changed = false;
      this.varcs = new int[WorldMapType1.configsIndex.fileCount(19)];
      this.varcstrings = new String[WorldMapType1.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class244 var2 = Actor.method1545(var1);
         this.varcSerials[var1] = var2.field3302;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class245 var3 = GameObject.method2938(var1);
         this.varcstringSerials[var1] = var3.field3308;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)Ldk;",
      garbageValue = "65"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return TextureProvider.getPreferencesFile("2", class29.field424.field3175, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "466264957"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-717705614"
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
               var2 += 2 + class45.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = class170.currentTimeMs();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2084455968"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label187: {
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
            if(var13.payload.length - var13.offset >= 1) {
               int var5 = var13.readUnsignedByte();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

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
                     break label187;
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
            break label187;
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "-7149"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-963072922"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-657592773"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "827703418"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "22545608"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "488364991"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < class170.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1588044677"
   )
   public static boolean method1846() {
      try {
         if(class204.field2487 == 2) {
            if(class169.field2322 == null) {
               class169.field2322 = Track1.getMusicFile(class204.field2488, class12.field273, class204.field2489);
               if(class169.field2322 == null) {
                  return false;
               }
            }

            if(CollisionData.field2270 == null) {
               CollisionData.field2270 = new class113(class204.field2484, class204.field2483);
            }

            if(class204.field2486.method3703(class169.field2322, class204.field2492, CollisionData.field2270, 22050)) {
               class204.field2486.method3704();
               class204.field2486.method3729(class204.field2490);
               class204.field2486.method3706(class169.field2322, class33.field472);
               class204.field2487 = 0;
               class169.field2322 = null;
               CollisionData.field2270 = null;
               class204.field2488 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class204.field2486.method3738();
         class204.field2487 = 0;
         class169.field2322 = null;
         CollisionData.field2270 = null;
         class204.field2488 = null;
      }

      return false;
   }
}
