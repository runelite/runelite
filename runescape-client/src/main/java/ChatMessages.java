import java.awt.event.ActionEvent;
import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("t")
   boolean[] field254;
   @ObfuscatedName("y")
   boolean[] field255;
   @ObfuscatedName("m")
   boolean field257 = false;
   @ObfuscatedName("p")
   int[] field258;
   @ObfuscatedName("g")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("en")
   static SpritePixels[] field260;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 5446340795262464009L
   )
   long field261;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1782186851"
   )
   static int method195(int var0) {
      MessageNode var1 = (MessageNode)class11.field168.method3792((long)var0);
      return null == var1?-1:(class11.field165.field3150 == var1.previous?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "42"
   )
   void method196(int var1, int var2) {
      this.field258[var1] = var2;
      if(this.field254[var1]) {
         this.field257 = true;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1239388902"
   )
   int method197(int var1) {
      return this.field258[var1];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1502091049"
   )
   void method198(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field255[var1]) {
         this.field257 = true;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "-10628"
   )
   String method199(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "123"
   )
   boolean method201() {
      return this.field257;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1764881759"
   )
   void method202() {
      FileOnDisk var1 = this.method218(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field258.length; ++var4) {
            if(this.field254[var4] && this.field258[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field255[var5] && null != this.messages[var5]) {
               var2 += 2 + class113.method2395(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2467(1);
         var9.method2468(var3);

         int var6;
         for(var6 = 0; var6 < this.field258.length; ++var6) {
            if(this.field254[var6] && this.field258[var6] != -1) {
               var9.method2468(var6);
               var9.method2642(this.field258[var6]);
            }
         }

         var9.method2468(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field255[var6] && null != this.messages[var6]) {
               var9.method2468(var6);
               var9.method2472(this.messages[var6]);
            }
         }

         var1.method4124(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4128();
         } catch (Exception var16) {
            ;
         }

      }

      this.field257 = false;
      this.field261 = class113.method2394();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1146525688"
   )
   void method204() {
      if(this.field257 && this.field261 < class113.method2394() - 60000L) {
         this.method202();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-107"
   )
   void method205() {
      int var1;
      for(var1 = 0; var1 < this.field258.length; ++var1) {
         if(!this.field254[var1]) {
            this.field258[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field255[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   ChatMessages() {
      this.field258 = new int[class10.field154.method3260(19)];
      this.messages = new String[class10.field154.method3260(15)];
      this.field254 = new boolean[this.field258.length];

      int var1;
      for(var1 = 0; var1 < this.field258.length; ++var1) {
         class47 var3 = (class47)class47.field1019.get((long)var1);
         class47 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class47.field1026.method3272(19, var1);
            var3 = new class47();
            if(var4 != null) {
               var3.method943(new Buffer(var4));
            }

            class47.field1019.put(var3, (long)var1);
            var2 = var3;
         }

         this.field254[var1] = var2.field1020;
      }

      this.field255 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var5 = class10.method128(var1);
         this.field255[var1] = var5.field1121;
      }

      for(var1 = 0; var1 < this.field258.length; ++var1) {
         this.field258[var1] = -1;
      }

      this.method219();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "-15"
   )
   FileOnDisk method218(boolean var1) {
      return class47.method945("2", Client.field466.field2330, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-784699531"
   )
   void method219() {
      FileOnDisk var1 = this.method218(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4130()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4127(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
               int var14 = var13.method2481();
               if(var14 < 0 || var14 > 1) {
                  return;
               }

               int var15 = var13.method2668();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2668();
                  var9 = var13.method2526();
                  if(this.field254[var8]) {
                     this.field258[var8] = var9;
                  }
               }

               var7 = var13.method2668();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var13.method2668();
                  String var10 = var13.method2503();
                  if(this.field255[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label192;
         } finally {
            try {
               var1.method4128();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field257 = false;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "1876422559"
   )
   static void method221(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var1 == var6.parentId) {
            class1.method6(var6, var2, var3, var4);
            class53.method1050(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               Projectile.method99(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1147054395"
   )
   static boolean method222(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = XItemContainer.method178(var0, Client.field518);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(XItemContainer.method178(Client.friends[var3].name, Client.field518)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(XItemContainer.method178(TextureProvider.localPlayer.name, Client.field518))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/lang/Object;I)V",
      garbageValue = "-2015407765"
   )
   static void method223(class139 var0, Object var1) {
      if(null != var0.field2141) {
         for(int var2 = 0; var2 < 50 && var0.field2141.peekEvent() != null; ++var2) {
            class16.method185(1L);
         }

         if(var1 != null) {
            var0.field2141.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
