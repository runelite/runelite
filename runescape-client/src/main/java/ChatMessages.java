import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -1762249067
   )
   protected static int field907;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -6131008743891394631L
   )
   long field908;
   @ObfuscatedName("h")
   boolean[] field910;
   @ObfuscatedName("g")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("k")
   boolean field913 = false;
   @ObfuscatedName("f")
   boolean[] field914;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -977171249
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("a")
   int[] field917;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1124130707
   )
   static int field918;
   @ObfuscatedName("ab")
   static class184 field919;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-20707"
   )
   void method800(int var1, int var2) {
      this.field917[var1] = var2;
      if(this.field914[var1]) {
         this.field913 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-77102159"
   )
   int method801(int var1) {
      return this.field917[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "65"
   )
   void method802(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field910[var1]) {
         this.field913 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-545179796"
   )
   String method803(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method804() {
      int var1;
      for(var1 = 0; var1 < this.field917.length; ++var1) {
         if(!this.field914[var1]) {
            this.field917[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field910[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   void method806() {
      FileOnDisk var1 = this.method825(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field917.length; ++var4) {
            if(this.field914[var4] && this.field917[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field910[var5] && null != this.messages[var5]) {
               String var8 = this.messages[var5];
               int var7 = var8.length() + 1;
               var2 += var7 + 2;
               ++var4;
            }
         }

         Buffer var11 = new Buffer(var2);
         var11.method2708(1);
         var11.method2709(var3);

         int var6;
         for(var6 = 0; var6 < this.field917.length; ++var6) {
            if(this.field914[var6] && this.field917[var6] != -1) {
               var11.method2709(var6);
               var11.method2711(this.field917[var6]);
            }
         }

         var11.method2709(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field910[var6] && this.messages[var6] != null) {
               var11.method2709(var6);
               var11.method2714(this.messages[var6]);
            }
         }

         var1.method1396(var11.payload, 0, var11.offset);
      } catch (Exception var19) {
         ;
      } finally {
         try {
            var1.method1378();
         } catch (Exception var18) {
            ;
         }

      }

      this.field913 = false;
      this.field908 = class2.method27();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1898197245"
   )
   void method808() {
      if(this.field913 && this.field908 < class2.method27() - 60000L) {
         this.method806();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method809() {
      FileOnDisk var1 = this.method825(false);

      label189: {
         try {
            byte[] var2 = new byte[(int)var1.method1379()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method1380(var2, var3, var2.length - var3);
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
                  var9 = var13.method2727();
                  if(this.field914[var8]) {
                     this.field917[var8] = var9;
                  }
               }

               var7 = var13.readUnsignedShort();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label189;
                  }

                  var9 = var13.readUnsignedShort();
                  String var10 = var13.method2911();
                  if(this.field910[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label189;
         } finally {
            try {
               var1.method1378();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field913 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1588023011"
   )
   boolean method812() {
      return this.field913;
   }

   ChatMessages() {
      this.field917 = new int[field919.method3192(19)];
      this.messages = new String[field919.method3192(15)];
      this.field914 = new boolean[this.field917.length];

      int var1;
      for(var1 = 0; var1 < this.field917.length; ++var1) {
         class188 var2 = Client.method446(var1);
         this.field914[var1] = var2.field2785;
      }

      this.field910 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var3 = (class189)class189.field2788.get((long)var1);
         class189 var5;
         if(var3 != null) {
            var5 = var3;
         } else {
            byte[] var4 = class157.field2130.getConfigData(15, var1);
            var3 = new class189();
            if(null != var4) {
               var3.method3348(new Buffer(var4));
            }

            class189.field2788.put(var3, (long)var1);
            var5 = var3;
         }

         this.field910[var1] = var5.field2789;
      }

      for(var1 = 0; var1 < this.field917.length; ++var1) {
         this.field917[var1] = -1;
      }

      this.method809();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "327126049"
   )
   FileOnDisk method825(boolean var1) {
      return class32.method667("2", class183.field2729.field2688, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   public static int method829() {
      return class105.keyboardIdleTicks;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1973055622"
   )
   static final void method830() {
      if(class47.field929 != null) {
         class47.field929.method1033();
      }

      if(GameObject.field1626 != null) {
         GameObject.field1626.method1033();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-363663110"
   )
   public static int method831(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
