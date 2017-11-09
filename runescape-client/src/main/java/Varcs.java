import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -181253951
   )
   static int field1423;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("i")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("j")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("v")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("x")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("e")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -6610946760644366049L
   )
   @Export("lastSerialize")
   long lastSerialize;

   Varcs() {
      this.changed = false;
      this.varcs = new int[GrandExchangeOffer.configsIndex.fileCount(19)];
      this.varcstrings = new String[GrandExchangeOffer.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class250 var2 = class34.method538(var1);
         this.varcSerials[var1] = var2.field3370;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class251 var3 = class176.method3251(var1);
         this.varcstringSerials[var1] = var3.field3377;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1931991987"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-43735639"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-127781076"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1462230819"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Ldj;",
      garbageValue = "-315190637"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return CollisionData.getPreferencesFile("2", class41.field528.field3261, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "953944330"
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
               var2 += 2 + Projectile.getLength(this.varcstrings[var5]);
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
      this.lastSerialize = class268.currentTimeMs();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-239636185"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < class268.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-5"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1419290560"
   )
   static final void method1903() {
      if(!class133.field1915) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class133.field1914 - Graphics3D.centerX) * var4 / Graphics3D.field1940;
         int var7 = (class133.field1912 - Graphics3D.centerY) * var4 / Graphics3D.field1940;
         int var8 = (class133.field1914 - Graphics3D.centerX) * var5 / Graphics3D.field1940;
         int var9 = (class133.field1912 - Graphics3D.centerY) * var5 / Graphics3D.field1940;
         int var10 = Graphics3D.method2726(var7, var4, var1, var0);
         int var11 = Graphics3D.method2767(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2726(var9, var5, var1, var0);
         int var12 = Graphics3D.method2767(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2724(var6, var11, var3, var2);
         var11 = Graphics3D.method2725(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2724(var8, var12, var3, var2);
         var12 = Graphics3D.method2725(var8, var12, var3, var2);
         class133.field1919 = (var10 + var6) / 2;
         class133.field1916 = (var9 + var7) / 2;
         class35.field475 = (var12 + var11) / 2;
         class133.field1918 = (var10 - var6) / 2;
         class258.field3444 = (var9 - var7) / 2;
         class133.field1913 = (var12 - var11) / 2;
         field1423 = Math.abs(class133.field1918);
         class133.field1920 = Math.abs(class258.field3444);
         class239.field3259 = Math.abs(class133.field1913);
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "126"
   )
   static final void method1904() {
      class170 var0 = Actor.method1628(ClientPacket.field2376, Client.field952.field1478);
      var0.field2423.putByte(0);
      Client.field952.method1951(var0);
   }
}
