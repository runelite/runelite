import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("a")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7557978941889218979L
   )
   @Export("lastSerialize")
   long lastSerialize;
   @ObfuscatedName("s")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("r")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("v")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("t")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1899521483"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-746461368"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1990367315"
   )
   @Export("putVarcString")
   void putVarcString(int var1, String var2) {
      this.varcstrings[var1] = var2;
      if(this.varcstringSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1335115471"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1875973342"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

      label195: {
         try {
            byte[] var2 = new byte[(int)var1.length()];

            int var3;
            for(int var4 = 0; var4 < var2.length; var4 += var3) {
               var3 = var1.read(var2, var4, var2.length - var4);
               if(var3 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var23 = new Buffer(var2);
            if(var23.payload.length - var23.offset < 1) {
               return;
            }

            int var5 = var23.readUnsignedByte();
            if(var5 >= 0 && var5 <= 1) {
               int var6 = var23.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.readUnsignedShort();
                  var9 = var23.readInt();
                  if(this.varcSerials[var8]) {
                     this.varcs[var8] = var9;
                  }
               }

               var7 = var23.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label195;
                  }

                  var9 = var23.readUnsignedShort();
                  String var10 = var23.readString();
                  if(this.varcstringSerials[var9]) {
                     this.varcstrings[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label195;
         } finally {
            try {
               var1.close();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.changed = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1809469181"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return class22.getPreferencesFile("2", Client.field1207.field3203, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
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
               var2 += 2 + class261.getLength(this.varcstrings[var5]);
               ++var4;
            }
         }

         Buffer var17 = new Buffer(var2);
         var17.putByte(1);
         var17.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.varcs.length; ++var6) {
            if(this.varcSerials[var6] && this.varcs[var6] != -1) {
               var17.putShort(var6);
               var17.putInt(this.varcs[var6]);
            }
         }

         var17.putShort(var4);

         for(var6 = 0; var6 < this.varcstrings.length; ++var6) {
            if(this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
               var17.putShort(var6);
               var17.putString(this.varcstrings[var6]);
            }
         }

         var1.write(var17.payload, 0, var17.offset);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var14) {
            ;
         }

      }

      this.changed = false;
      this.lastSerialize = DState.currentTimeMs();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-650121609"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   @Export("process")
   void process() {
      if(this.changed && this.lastSerialize < DState.currentTimeMs() - 60000L) {
         this.serialize();
      }

   }

   Varcs() {
      this.changed = false;
      this.varcs = new int[class91.configsIndex.fileCount(19)];
      this.varcstrings = new String[class91.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         class243 var2 = (class243)class243.field3317.get((long)var1);
         class243 var3;
         if(var2 != null) {
            var3 = var2;
         } else {
            byte[] var4 = class243.field3319.getConfigData(19, var1);
            var2 = new class243();
            if(var4 != null) {
               var2.method4315(new Buffer(var4));
            }

            class243.field3317.put(var2, (long)var1);
            var3 = var2;
         }

         this.varcSerials[var1] = var3.field3318;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         class244 var5 = class205.getVarClientStringType(var1);
         this.varcstringSerials[var1] = var5.field3323;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }
}
