import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("n")
   boolean[] field909;
   @ObfuscatedName("q")
   boolean[] field910;
   @ObfuscatedName("t")
   int[] field911;
   @ObfuscatedName("u")
   boolean field913;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 6724377469146054465L
   )
   long field914;
   @ObfuscatedName("qm")
   protected static class109 field916;
   @ObfuscatedName("pc")
   static IndexFile field919;
   @ObfuscatedName("in")
   static Widget field920;
   @ObfuscatedName("p")
   @Export("messages")
   String[] messages;

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "101"
   )
   static boolean method857(Widget var0) {
      if(Client.field455) {
         if(class103.method1988(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-30"
   )
   void method858(int var1, int var2) {
      this.field911[var1] = var2;
      if(this.field909[var1]) {
         this.field913 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1262170686"
   )
   int method859(int var1) {
      return this.field911[var1];
   }

   ChatMessages() {
      this.field913 = false;
      this.field911 = new int[class213.field3150.method3305(19)];
      this.messages = new String[class213.field3150.method3305(15)];
      this.field909 = new boolean[this.field911.length];

      int var1;
      for(var1 = 0; var1 < this.field911.length; ++var1) {
         class190 var2 = CollisionData.method2279(var1);
         this.field909[var1] = var2.field2790;
      }

      this.field910 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class191 var3 = (class191)class191.field2795.get((long)var1);
         class191 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class191.field2797.getConfigData(15, var1);
            var3 = new class191();
            if(var4 != null) {
               var3.method3465(new Buffer(var4));
            }

            class191.field2795.put(var3, (long)var1);
            var5 = var3;
         }

         this.field910[var1] = var5.field2796;
      }

      for(var1 = 0; var1 < this.field911.length; ++var1) {
         this.field911[var1] = -1;
      }

      this.method864();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "899201861"
   )
   void method861() {
      int var1;
      for(var1 = 0; var1 < this.field911.length; ++var1) {
         if(!this.field909[var1]) {
            this.field911[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field910[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1119223901"
   )
   FileOnDisk method862(boolean var1) {
      return class59.getPreferencesFile("2", class188.field2778.name, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1870496791"
   )
   void method863() {
      FileOnDisk var1 = this.method862(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field911.length; ++var4) {
            if(this.field909[var4] && this.field911[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field910[var5] && this.messages[var5] != null) {
               var2 += class36.method753(this.messages[var5]) + 2;
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.putByte(1);
         var9.putShort(var3);

         int var6;
         for(var6 = 0; var6 < this.field911.length; ++var6) {
            if(this.field909[var6] && this.field911[var6] != -1) {
               var9.putShort(var6);
               var9.putInt(this.field911[var6]);
            }
         }

         var9.putShort(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field910[var6] && this.messages[var6] != null) {
               var9.putShort(var6);
               var9.method2504(this.messages[var6]);
            }
         }

         var1.method1424(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1425();
         } catch (Exception var16) {
            ;
         }

      }

      this.field913 = false;
      this.field914 = class72.method1421();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112281794"
   )
   void method864() {
      FileOnDisk var1 = this.method862(false);

      label188: {
         try {
            byte[] var2 = new byte[(int)var1.method1438()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1427(var2, var3, var2.length - var3);
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
                  if(this.field909[var8]) {
                     this.field911[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label188;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.readString();
                  if(this.field910[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label188;
         } finally {
            try {
               var1.method1425();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field913 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2085524037"
   )
   void method865() {
      if(this.field913 && this.field914 < class72.method1421() - 60000L) {
         this.method863();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1668513932"
   )
   boolean method866() {
      return this.field913;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "0"
   )
   void method875(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field910[var1]) {
         this.field913 = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "37330559"
   )
   String method886(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1311944478"
   )
   static void method890(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
