import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("x")
   boolean[] field917;
   @ObfuscatedName("ac")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("q")
   boolean[] field919;
   @ObfuscatedName("k")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("j")
   boolean field922 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -1519880385389852639L
   )
   long field923;
   @ObfuscatedName("d")
   int[] field925;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1172307390"
   )
   void method823(int var1, int var2) {
      this.field925[var1] = var2;
      if(this.field917[var1]) {
         this.field922 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1455106229"
   )
   int method824(int var1) {
      return this.field925[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "80"
   )
   public static int method825(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   void method827() {
      int var1;
      for(var1 = 0; var1 < this.field925.length; ++var1) {
         if(!this.field917[var1]) {
            this.field925[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field919[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1984147315"
   )
   FileOnDisk method828(boolean var1) {
      return class37.method728("2", class155.field2107.field2688, var1);
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-2099541582"
   )
   static final boolean method829(Widget var0) {
      if(var0.field2278 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2278.length; ++var1) {
            int var2 = ChatLineBuffer.method895(var0, var1);
            int var3 = var0.field2310[var1];
            if(var0.field2278[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2278[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2278[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-16257"
   )
   void method830() {
      FileOnDisk var1 = this.method828(false);

      label201: {
         try {
            byte[] var2 = new byte[(int)var1.method1418()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1405(var2, var3, var2.length - var3);
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
                  var9 = var13.method2819();
                  if(this.field917[var8]) {
                     this.field925[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label201;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.method2846();
                  if(this.field919[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label201;
         } finally {
            try {
               var1.method1403();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field922 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "47893695"
   )
   void method831() {
      if(this.field922 && this.field923 < FrameMap.method1695() - 60000L) {
         this.method844();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1868058381"
   )
   boolean method832() {
      return this.field922;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-23"
   )
   String method839(int var1) {
      return this.messages[var1];
   }

   ChatMessages() {
      this.field925 = new int[class7.field65.method3309(19)];
      this.messages = new String[class7.field65.method3309(15)];
      this.field917 = new boolean[this.field925.length];

      int var1;
      for(var1 = 0; var1 < this.field925.length; ++var1) {
         class188 var3 = (class188)class188.field2777.get((long)var1);
         class188 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class188.field2778.getConfigData(19, var1);
            var3 = new class188();
            if(null != var4) {
               var3.method3432(new Buffer(var4));
            }

            class188.field2777.put(var3, (long)var1);
            var2 = var3;
         }

         this.field917[var1] = var2.field2779;
      }

      this.field919 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class146.method2748(var1);
         this.field919[var1] = var5.field2784;
      }

      for(var1 = 0; var1 < this.field925.length; ++var1) {
         this.field925[var1] = -1;
      }

      this.method830();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1785896797"
   )
   void method844() {
      FileOnDisk var1 = this.method828(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field925.length; ++var4) {
            if(this.field917[var4] && this.field925[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field919[var5] && null != this.messages[var5]) {
               var2 += 2 + class37.method737(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2799(1);
         var9.method2837(var3);

         int var6;
         for(var6 = 0; var6 < this.field925.length; ++var6) {
            if(this.field917[var6] && this.field925[var6] != -1) {
               var9.method2837(var6);
               var9.method2802(this.field925[var6]);
            }
         }

         var9.method2837(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field919[var6] && null != this.messages[var6]) {
               var9.method2837(var6);
               var9.method2805(this.messages[var6]);
            }
         }

         var1.method1402(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1403();
         } catch (Exception var16) {
            ;
         }

      }

      this.field922 = false;
      this.field923 = FrameMap.method1695();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-598023986"
   )
   void method860(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field919[var1]) {
         this.field922 = true;
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-298356064"
   )
   static void method861(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2251 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2251 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2251 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2204 == 0) {
         var0.height = var0.field2241;
      } else if(var0.field2204 == 1) {
         var0.height = var2 - var0.field2241;
      } else if(var0.field2204 == 2) {
         var0.height = var0.field2241 * var2 >> 14;
      }

      if(var0.field2251 == 4) {
         var0.width = var0.height * var0.field2254 / var0.field2291;
      }

      if(var0.field2204 == 4) {
         var0.height = var0.width * var0.field2291 / var0.field2254;
      }

      if(Client.field505 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field449 = var0;
      }

      if(var3 && var0.field2305 != null && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field180 = var0;
         var6.field188 = var0.field2305;
         Client.field476.method2407(var6);
      }

   }
}
