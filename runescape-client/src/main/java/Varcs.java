import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field1419;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -348916263
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("b")
   @Export("varcSerials")
   boolean[] varcSerials;
   @ObfuscatedName("z")
   @Export("varcstringSerials")
   boolean[] varcstringSerials;
   @ObfuscatedName("n")
   @Export("varcs")
   int[] varcs;
   @ObfuscatedName("l")
   @Export("varcstrings")
   String[] varcstrings;
   @ObfuscatedName("s")
   @Export("changed")
   boolean changed;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 5184275220869040693L
   )
   long field1425;

   Varcs() {
      this.changed = false;
      this.varcs = new int[Client.configsIndex.fileCount(19)];
      this.varcstrings = new String[Client.configsIndex.fileCount(15)];
      this.varcSerials = new boolean[this.varcs.length];

      int var1;
      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         VarCInt var2 = AbstractSoundSystem.method2349(var1);
         this.varcSerials[var1] = var2.field3473;
      }

      this.varcstringSerials = new boolean[this.varcstrings.length];

      for(var1 = 0; var1 < this.varcstrings.length; ++var1) {
         VarCString var3 = class190.method3560(var1);
         this.varcstringSerials[var1] = var3.field3479;
      }

      for(var1 = 0; var1 < this.varcs.length; ++var1) {
         this.varcs[var1] = -1;
      }

      this.deserialize();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1337942690"
   )
   @Export("putVarc")
   void putVarc(int var1, int var2) {
      this.varcs[var1] = var2;
      if(this.varcSerials[var1]) {
         this.changed = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "71"
   )
   @Export("getVarc")
   int getVarc(int var1) {
      return this.varcs[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1404232047"
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
      garbageValue = "26553794"
   )
   @Export("getVarcString")
   String getVarcString(int var1) {
      return this.varcstrings[var1];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "279700861"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZB)Ldb;",
      garbageValue = "1"
   )
   @Export("getVarPrefs")
   FileOnDisk getVarPrefs(boolean var1) {
      return BaseVarType.getPreferencesFile("2", TotalQuantityComparator.field296.name, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-742267132"
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
               var2 += 2 + class95.getLength(this.varcstrings[var5]);
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
      this.field1425 = class289.method5267();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   @Export("deserialize")
   void deserialize() {
      FileOnDisk var1 = this.getVarPrefs(false);

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

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.readInt();
            if(this.varcSerials[var8]) {
               this.varcs[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.readString();
            if(this.varcstringSerials[var9]) {
               this.varcstrings[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var23) {
            ;
         }

      }

      this.changed = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22568"
   )
   @Export("process")
   void process() {
      if(this.changed && this.field1425 < class289.method5267() - 60000L) {
         this.serialize();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   @Export("changed")
   boolean changed() {
      return this.changed;
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Lbm;B)V",
      garbageValue = "41"
   )
   static final void method2075(Actor var0) {
      if(var0.field1193 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1167) {
               var0.interacting = -1;
               var0.field1167 = false;
            }
         }

         if(var0.field1168 != -1 && (var0.queueSize == 0 || var0.field1192 > 0)) {
            var0.orientation = var0.field1168;
            var0.field1168 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1167) {
            var0.interacting = -1;
            var0.field1167 = false;
         }

         if(var4 != 0) {
            ++var0.field1177;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1193;
               var6 = true;
               if(var4 < var0.field1193 || var4 > 2048 - var0.field1193) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1177 > 25 || var6)) {
                  if(var0.field1189 != -1) {
                     var0.poseAnimation = var0.field1189;
                  } else {
                     var0.poseAnimation = var0.field1148;
                  }
               }
            } else {
               var0.angle += var0.field1193;
               var6 = true;
               if(var4 < var0.field1193 || var4 > 2048 - var0.field1193) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1177 > 25 || var6)) {
                  if(var0.field1157 != -1) {
                     var0.poseAnimation = var0.field1157;
                  } else {
                     var0.poseAnimation = var0.field1148;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1177 = 0;
         }

      }
   }
}
