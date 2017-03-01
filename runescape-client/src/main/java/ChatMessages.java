import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("j")
   boolean field929 = false;
   @ObfuscatedName("g")
   boolean[] field930;
   @ObfuscatedName("v")
   boolean[] field931;
   @ObfuscatedName("y")
   int[] field932;
   @ObfuscatedName("p")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5326951630799346909L
   )
   long field937;
   @ObfuscatedName("c")
   static Buffer field939;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1056179872"
   )
   void method918() {
      if(this.field929 && this.field937 < WallObject.method1985() - 60000L) {
         this.method925();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-2001730745"
   )
   public static String method919(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3084[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "101"
   )
   int method920(int var1) {
      return this.field932[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "10"
   )
   void method921(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field931[var1]) {
         this.field929 = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1052432067"
   )
   String method922(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   void method925() {
      FileOnDisk var1 = this.method944(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field932.length; ++var4) {
            if(this.field930[var4] && this.field932[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field931[var5] && this.messages[var5] != null) {
               var2 += 2 + class165.method3233(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2873(1);
         var9.method2872(var3);

         int var6;
         for(var6 = 0; var6 < this.field932.length; ++var6) {
            if(this.field930[var6] && this.field932[var6] != -1) {
               var9.method2872(var6);
               var9.method2874(this.field932[var6]);
            }
         }

         var9.method2872(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field931[var6] && null != this.messages[var6]) {
               var9.method2872(var6);
               var9.method2915(this.messages[var6]);
            }
         }

         var1.method1495(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1488();
         } catch (Exception var16) {
            ;
         }

      }

      this.field929 = false;
      this.field937 = WallObject.method1985();
   }

   ChatMessages() {
      this.field932 = new int[Client.field499.method3352(19)];
      this.messages = new String[Client.field499.method3352(15)];
      this.field930 = new boolean[this.field932.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field932.length; ++var1) {
         class188 var3 = (class188)class188.field2783.get((long)var1);
         class188 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            var4 = class188.field2786.getConfigData(19, var1);
            var3 = new class188();
            if(var4 != null) {
               var3.method3510(new Buffer(var4));
            }

            class188.field2783.put(var3, (long)var1);
            var2 = var3;
         }

         this.field930[var1] = var2.field2784;
      }

      this.field931 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var6 = (class189)class189.field2788.get((long)var1);
         class189 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class189.field2793.getConfigData(15, var1);
            var6 = new class189();
            if(var4 != null) {
               var6.method3523(new Buffer(var4));
            }

            class189.field2788.put(var6, (long)var1);
            var5 = var6;
         }

         this.field931[var1] = var5.field2787;
      }

      for(var1 = 0; var1 < this.field932.length; ++var1) {
         this.field932[var1] = -1;
      }

      this.method948();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-18111"
   )
   boolean method927() {
      return this.field929;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   void method930() {
      int var1;
      for(var1 = 0; var1 < this.field932.length; ++var1) {
         if(!this.field930[var1]) {
            this.field932[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field931[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-78402552"
   )
   FileOnDisk method944(boolean var1) {
      return CombatInfo2.method3608("2", Client.field312.field2687, var1);
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1818709916"
   )
   static void method947(Widget var0, int var1, int var2) {
      if(var0.field2211 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2211 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2211 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2211 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2211 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2212 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2212 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2212 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2212 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2212 == 4) {
         var0.relativeY = (var0.originalY * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field470 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1683098570"
   )
   void method948() {
      FileOnDisk var1 = this.method944(false);

      label191: {
         try {
            byte[] var2 = new byte[(int)var1.method1489()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1490(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.readUnsignedByte();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.readUnsignedShort();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.readUnsignedShort();
                  var9 = var13.readInt();
                  if(this.field930[var8]) {
                     this.field932[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label191;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field931[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label191;
         } finally {
            try {
               var1.method1488();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field929 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "837679402"
   )
   void method949(int var1, int var2) {
      this.field932[var1] = var2;
      if(this.field930[var1]) {
         this.field929 = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1848674932"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2900.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2925.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2921 = var0;
         if(var2 != null) {
            var1.method3696(new Buffer(var2));
         }

         var1.method3661();
         if(var1.isSolid) {
            var1.field2915 = 0;
            var1.field2936 = false;
         }

         ObjectComposition.field2900.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)Ljava/lang/String;",
      garbageValue = "-962393878"
   )
   public static String method955(Buffer var0) {
      return Tile.method1641(var0, 32767);
   }
}
