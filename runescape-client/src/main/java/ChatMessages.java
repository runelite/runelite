import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("c")
   boolean field1512;
   @ObfuscatedName("i")
   boolean[] field1513;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -8668707020405231005L
   )
   long field1514;
   @ObfuscatedName("f")
   int[] field1515;
   @ObfuscatedName("m")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("j")
   boolean[] field1522;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-194588"
   )
   void method1765() {
      FileOnDisk var1 = this.method1771(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method2370()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method2369(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset >= 1) {
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
                  if(this.field1513[var8]) {
                     this.field1515[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field1522[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label192;
         } finally {
            try {
               var1.method2368();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field1512 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1197332154"
   )
   void method1766(int var1, int var2) {
      this.field1515[var1] = var2;
      if(this.field1513[var1]) {
         this.field1512 = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "6"
   )
   int method1767(int var1) {
      return this.field1515[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "7"
   )
   void method1768(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field1522[var1]) {
         this.field1512 = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   String method1769(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1074706482"
   )
   void method1770() {
      if(this.field1512 && this.field1514 < class134.method2587() - 60000L) {
         this.method1772();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZS)LFileOnDisk;",
      garbageValue = "256"
   )
   FileOnDisk method1771(boolean var1) {
      return class163.getPreferencesFile("2", Client.field916.field3197, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1772() {
      FileOnDisk var1 = this.method1771(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field1515.length; ++var4) {
            if(this.field1513[var4] && this.field1515[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field1522[var5] && this.messages[var5] != null) {
               var2 += Script.method1836(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field1515.length; ++var6) {
            if(this.field1513[var6] && this.field1515[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field1515[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field1522[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method3150(this.messages[var6]);
            }
         }

         var1.method2366(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method2368();
         } catch (Exception var16) {
            ;
         }

      }

      this.field1512 = false;
      this.field1514 = class134.method2587();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1248106958"
   )
   boolean method1775() {
      return this.field1512;
   }

   ChatMessages() {
      this.field1512 = false;
      this.field1515 = new int[NPC.field1374.method4174(19)];
      this.messages = new String[NPC.field1374.method4174(15)];
      this.field1513 = new boolean[this.field1515.length];

      int var1;
      for(var1 = 0; var1 < this.field1515.length; ++var1) {
         class243 var2 = WidgetNode.method1065(var1);
         this.field1513[var1] = var2.field3317;
      }

      this.field1522 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class244 var3 = RSSocket.method3006(var1);
         this.field1522[var1] = var3.field3322;
      }

      for(var1 = 0; var1 < this.field1515.length; ++var1) {
         this.field1515[var1] = -1;
      }

      this.method1765();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1148884799"
   )
   void method1793() {
      int var1;
      for(var1 = 0; var1 < this.field1515.length; ++var1) {
         if(!this.field1513[var1]) {
            this.field1515[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field1522[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass186;I)Lclass186;",
      garbageValue = "1841167521"
   )
   static final class186 method1795(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class13.method88(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new class198(var0.readInt());
         }

         var1.method3494((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-113"
   )
   static final void method1800(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class73.field867[Client.field1024 / 100].method5097(Client.field1022 - 8, Client.field970 - 8);
      }

      if(Client.cursorState == 2) {
         class73.field867[Client.field1024 / 100 + 4].method5097(Client.field1022 - 8, Client.field970 - 8);
      }

      Client.field1034 = 0;
      int var4 = (class168.localPlayer.x >> 7) + class61.baseX;
      int var5 = (class168.localPlayer.y >> 7) + class23.baseY;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field1034 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field1034 = 1;
      }

      if(Client.field1034 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field1034 = 0;
      }

   }
}
