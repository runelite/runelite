import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("h")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("c")
   boolean[] field940;
   @ObfuscatedName("w")
   int[] field942;
   @ObfuscatedName("d")
   boolean[] field943;
   @ObfuscatedName("u")
   boolean field944 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 6665537986684285387L
   )
   long field945;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-3"
   )
   void method916(int var1, int var2) {
      this.field942[var1] = var2;
      if(this.field940[var1]) {
         this.field944 = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "727821487"
   )
   int method917(int var1) {
      return this.field942[var1];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "1107034004"
   )
   void method918(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field943[var1]) {
         this.field944 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1261030450"
   )
   String method919(int var1) {
      return this.messages[var1];
   }

   ChatMessages() {
      this.field942 = new int[class2.field27.method3316(19)];
      this.messages = new String[class2.field27.method3316(15)];
      this.field940 = new boolean[this.field942.length];

      int var1;
      for(var1 = 0; var1 < this.field942.length; ++var1) {
         class188 var3 = (class188)class188.field2779.get((long)var1);
         class188 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class188.field2775.getConfigData(19, var1);
            var3 = new class188();
            if(null != var4) {
               var3.method3459(new Buffer(var4));
            }

            class188.field2779.put(var3, (long)var1);
            var2 = var3;
         }

         this.field940[var1] = var2.field2774;
      }

      this.field943 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class159.method3098(var1);
         this.field943[var1] = var5.field2782;
      }

      for(var1 = 0; var1 < this.field942.length; ++var1) {
         this.field942[var1] = -1;
      }

      this.method933();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "-1"
   )
   FileOnDisk method920(boolean var1) {
      return class2.method33("2", WidgetNode.field218.field2677, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-280533460"
   )
   void method921() {
      FileOnDisk var1 = this.method920(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field942.length; ++var4) {
            if(this.field940[var4] && this.field942[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field943[var5] && null != this.messages[var5]) {
               var2 += 2 + class164.method3157(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2843(1);
         var9.method2817(var3);

         int var6;
         for(var6 = 0; var6 < this.field942.length; ++var6) {
            if(this.field940[var6] && this.field942[var6] != -1) {
               var9.method2817(var6);
               var9.method2819(this.field942[var6]);
            }
         }

         var9.method2817(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field943[var6] && null != this.messages[var6]) {
               var9.method2817(var6);
               var9.method2822(this.messages[var6]);
            }
         }

         var1.method1481(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1479();
         } catch (Exception var16) {
            ;
         }

      }

      this.field944 = false;
      this.field945 = class99.method2005();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   void method922() {
      int var1;
      for(var1 = 0; var1 < this.field942.length; ++var1) {
         if(!this.field940[var1]) {
            this.field942[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field943[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1032078422"
   )
   void method925() {
      if(this.field944 && this.field945 < class99.method2005() - 60000L) {
         this.method921();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1492591697"
   )
   void method933() {
      FileOnDisk var1 = this.method920(false);

      try {
         byte[] var2 = new byte[(int)var1.method1480()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method1476(var2, var3, var2.length - var3);
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
            if(this.field940[var8]) {
               this.field942[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.readString();
            if(this.field943[var9]) {
               this.messages[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method1479();
         } catch (Exception var23) {
            ;
         }

      }

      this.field944 = false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   boolean method939() {
      return this.field944;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "470804187"
   )
   static final void method942(boolean var0) {
      class47.method950();
      ++Client.field497;
      if(Client.field497 >= 50 || var0) {
         Client.field497 = 0;
         if(!Client.field587 && null != class1.field15) {
            Client.field309.method3076(184);

            try {
               class1.field15.method2117(Client.field309.payload, 0, Client.field309.offset);
               Client.field309.offset = 0;
            } catch (IOException var2) {
               Client.field587 = true;
            }
         }

      }
   }
}
