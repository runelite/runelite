import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("e")
   boolean[] field1504;
   @ObfuscatedName("t")
   boolean[] field1505;
   @ObfuscatedName("w")
   int[] field1506;
   @ObfuscatedName("z")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("j")
   boolean field1508;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2268265350302709669L
   )
   long field1509;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1871749460"
   )
   void method1703(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field1505[var1]) {
         this.field1508 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1338411676"
   )
   void method1705() {
      int var1;
      for(var1 = 0; var1 < this.field1506.length; ++var1) {
         if(!this.field1504[var1]) {
            this.field1506[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field1505[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1513240131"
   )
   void method1707() {
      FileOnDisk var1 = this.method1719(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field1506.length; ++var4) {
            if(this.field1504[var4] && this.field1506[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field1505[var5] && this.messages[var5] != null) {
               var2 += Friend.method1023(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field1506.length; ++var6) {
            if(this.field1504[var6] && this.field1506[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field1506[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field1505[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method3125(this.messages[var6]);
            }
         }

         var1.method2264(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method2274();
         } catch (Exception var16) {
            ;
         }

      }

      this.field1508 = false;
      this.field1509 = class166.method2970();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2132541353"
   )
   void method1708() {
      FileOnDisk var1 = this.method1719(false);

      label202: {
         try {
            byte[] var2 = new byte[(int)var1.method2266()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method2267(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
               int var5 = var13.readUnsignedByte();
               if(var5 >= 0 && var5 <= 1) {
                  int var6 = var13.readUnsignedShort();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = var13.readUnsignedShort();
                     var9 = var13.readInt();
                     if(this.field1504[var8]) {
                        this.field1506[var8] = var9;
                     }
                  }

                  var7 = var13.readUnsignedShort();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label202;
                     }

                     var9 = var13.readUnsignedShort();
                     String var10 = var13.readString();
                     if(this.field1505[var9]) {
                        this.messages[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var24) {
            break label202;
         } finally {
            try {
               var1.method2274();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field1508 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2052642475"
   )
   void method1709() {
      if(this.field1508 && this.field1509 < class166.method2970() - 60000L) {
         this.method1707();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-61"
   )
   boolean method1710() {
      return this.field1508;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   public static int method1716(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   ChatMessages() {
      this.field1508 = false;
      this.field1506 = new int[class3.field24.method4075(19)];
      this.messages = new String[class3.field24.method4075(15)];
      this.field1504 = new boolean[this.field1506.length];

      int var1;
      for(var1 = 0; var1 < this.field1506.length; ++var1) {
         class243 var2 = class221.method3958(var1);
         this.field1504[var1] = var2.field3320;
      }

      this.field1505 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class244 var3 = (class244)class244.field3328.get((long)var1);
         class244 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class21.field353.getConfigData(15, var1);
            var3 = new class244();
            if(var4 != null) {
               var3.method4201(new Buffer(var4));
            }

            class244.field3328.put(var3, (long)var1);
            var5 = var3;
         }

         this.field1505[var1] = var5.field3326;
      }

      for(var1 = 0; var1 < this.field1506.length; ++var1) {
         this.field1506[var1] = -1;
      }

      this.method1708();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "2060240580"
   )
   FileOnDisk method1719(boolean var1) {
      return TextureProvider.getPreferencesFile("2", Client.field1169.field3200, var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "255"
   )
   int method1722(int var1) {
      return this.field1506[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-2502"
   )
   void method1728(int var1, int var2) {
      this.field1506[var1] = var2;
      if(this.field1504[var1]) {
         this.field1508 = true;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "173312734"
   )
   String method1731(int var1) {
      return this.messages[var1];
   }
}
