import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("h")
   boolean[] field936;
   @ObfuscatedName("u")
   boolean[] field937;
   @ObfuscatedName("l")
   boolean field938 = false;
   @ObfuscatedName("r")
   int[] field939;
   @ObfuscatedName("o")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 703169951257247567L
   )
   long field942;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      longValue = 5001590869080087953L
   )
   static long field946;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2085704407"
   )
   void method870(int var1, int var2) {
      this.field939[var1] = var2;
      if(this.field937[var1]) {
         this.field938 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "613851975"
   )
   int method871(int var1) {
      return this.field939[var1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   String method873(int var1) {
      return this.messages[var1];
   }

   ChatMessages() {
      this.field939 = new int[ChatLineBuffer.field990.method3346(19)];
      this.messages = new String[ChatLineBuffer.field990.method3346(15)];
      this.field937 = new boolean[this.field939.length];

      int var1;
      for(var1 = 0; var1 < this.field939.length; ++var1) {
         class188 var2 = (class188)class188.field2795.get((long)var1);
         class188 var3;
         if(var2 != null) {
            var3 = var2;
         } else {
            byte[] var4 = class188.field2797.getConfigData(19, var1);
            var2 = new class188();
            if(var4 != null) {
               var2.method3500(new Buffer(var4));
            }

            class188.field2795.put(var2, (long)var1);
            var3 = var2;
         }

         this.field937[var1] = var3.field2794;
      }

      this.field936 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class20.method188(var1);
         this.field936[var1] = var5.field2800;
      }

      for(var1 = 0; var1 < this.field939.length; ++var1) {
         this.field939[var1] = -1;
      }

      this.method902();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   void method876() {
      FileOnDisk var1 = this.method883(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field939.length; ++var4) {
            if(this.field937[var4] && this.field939[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field936[var5] && this.messages[var5] != null) {
               var2 += class72.method1439(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var17 = new Buffer(var2);
         var17.putByte(1);
         var17.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field939.length; ++var6) {
            if(this.field937[var6] && this.field939[var6] != -1) {
               var17.putShort(var6);
               var17.putInt(this.field939[var6]);
            }
         }

         var17.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field936[var6] && this.messages[var6] != null) {
               var17.putShort(var6);
               var17.method2931(this.messages[var6]);
            }
         }

         var1.method1447(var17.payload, 0, var17.offset);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method1448();
         } catch (Exception var14) {
            ;
         }

      }

      this.field938 = false;
      this.field942 = class45.method867();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-497318759"
   )
   void method878() {
      if(this.field938 && this.field942 < class45.method867() - 60000L) {
         this.method876();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "0"
   )
   FileOnDisk method883(boolean var1) {
      return class45.method868("2", Client.field304.field2709, var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1159277952"
   )
   void method886() {
      int var1;
      for(var1 = 0; var1 < this.field939.length; ++var1) {
         if(!this.field937[var1]) {
            this.field939[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field936[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "338122289"
   )
   boolean method890() {
      return this.field938;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1238142862"
   )
   void method897(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field936[var1]) {
         this.field938 = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   void method902() {
      FileOnDisk var1 = this.method883(false);

      label196: {
         try {
            byte[] var2 = new byte[(int)var1.method1449()];

            int var3;
            for(int var4 = 0; var4 < var2.length; var4 += var3) {
               var3 = var1.method1450(var2, var4, var2.length - var4);
               if(var3 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var23 = new Buffer(var2);
            if(var23.payload.length - var23.offset >= 1) {
               int var5 = var23.readUnsignedByte();
               if(var5 >= 0 && var5 <= 1) {
                  int var6 = var23.readUnsignedShort();

                  int var7;
                  int var8;
                  int var9;
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = var23.readUnsignedShort();
                     var9 = var23.readInt();
                     if(this.field937[var8]) {
                        this.field939[var8] = var9;
                     }
                  }

                  var7 = var23.readUnsignedShort();
                  var8 = 0;

                  while(true) {
                     if(var8 >= var7) {
                        break label196;
                     }

                     var9 = var23.readUnsignedShort();
                     String var10 = var23.readString();
                     if(this.field936[var9]) {
                        this.messages[var9] = var10;
                     }

                     ++var8;
                  }
               }

               return;
            }
         } catch (Exception var21) {
            break label196;
         } finally {
            try {
               var1.method1448();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field938 = false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "248874894"
   )
   public static void method904() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1863610558"
   )
   static final void method905(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(Ignore.method178(var0)) {
         class162.field2170 = null;
         VertexNormal.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class162.field2170 != null) {
            VertexNormal.gameDraw(class162.field2170, -1412584499, var1, var2, var3, var4, class149.field2062, MessageNode.field245, var7);
            class162.field2170 = null;
         }
      } else if(var7 != -1) {
         Client.field508[var7] = true;
      } else {
         for(int var8 = 0; var8 < 100; ++var8) {
            Client.field508[var8] = true;
         }
      }

   }
}
