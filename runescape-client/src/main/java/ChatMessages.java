import java.awt.event.ActionEvent;
import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("aj")
   static class102 field934;
   @ObfuscatedName("p")
   boolean[] field937;
   @ObfuscatedName("j")
   int[] field938;
   @ObfuscatedName("n")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("r")
   boolean field940 = false;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 3253774505681400563L
   )
   long field941;
   @ObfuscatedName("h")
   boolean[] field943;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -515790537
   )
   protected static int field944;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-101"
   )
   void method907(int var1, int var2) {
      this.field938[var1] = var2;
      if(this.field943[var1]) {
         this.field940 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "19"
   )
   void method909(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field937[var1]) {
         this.field940 = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-125"
   )
   String method910(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   void method911() {
      int var1;
      for(var1 = 0; var1 < this.field938.length; ++var1) {
         if(!this.field943[var1]) {
            this.field938[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field937[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-1961521621"
   )
   FileOnDisk method912(boolean var1) {
      return class22.method220("2", Client.field306.field2689, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method913() {
      FileOnDisk var1 = this.method912(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field938.length; ++var4) {
            if(this.field943[var4] && this.field938[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field937[var5] && this.messages[var5] != null) {
               var2 += 2 + class119.method2340(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2918(1);
         var9.method2831(var3);

         int var6;
         for(var6 = 0; var6 < this.field938.length; ++var6) {
            if(this.field943[var6] && this.field938[var6] != -1) {
               var9.method2831(var6);
               var9.method2821(this.field938[var6]);
            }
         }

         var9.method2831(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field937[var6] && this.messages[var6] != null) {
               var9.method2831(var6);
               var9.method2824(this.messages[var6]);
            }
         }

         var1.method1469(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1475();
         } catch (Exception var16) {
            ;
         }

      }

      this.field940 = false;
      this.field941 = class0.method11();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method914() {
      FileOnDisk var1 = this.method912(false);

      try {
         byte[] var2 = new byte[(int)var1.method1477()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method1472(var2, var3, var2.length - var3);
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
            var9 = var13.method2965();
            if(this.field943[var8]) {
               this.field938[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.method2868();
            if(this.field937[var9]) {
               this.messages[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method1475();
         } catch (Exception var23) {
            ;
         }

      }

      this.field940 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2017607539"
   )
   void method915() {
      if(this.field940 && this.field941 < class0.method11() - 60000L) {
         this.method913();
      }

   }

   ChatMessages() {
      this.field938 = new int[class40.field833.method3313(19)];
      this.messages = new String[class40.field833.method3313(15)];
      this.field943 = new boolean[this.field938.length];

      int var1;
      for(var1 = 0; var1 < this.field938.length; ++var1) {
         class188 var3 = (class188)class188.field2786.get((long)var1);
         class188 var2;
         if(null != var3) {
            var2 = var3;
         } else {
            byte[] var4 = class188.field2789.getConfigData(19, var1);
            var3 = new class188();
            if(null != var4) {
               var3.method3452(new Buffer(var4));
            }

            class188.field2786.put(var3, (long)var1);
            var2 = var3;
         }

         this.field943[var1] = var2.field2788;
      }

      this.field937 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class94.method1978(var1);
         this.field937[var1] = var5.field2794;
      }

      for(var1 = 0; var1 < this.field938.length; ++var1) {
         this.field938[var1] = -1;
      }

      this.method914();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "14"
   )
   public static byte[] method918(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?Ignore.method207(var3):var3;
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3042();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-851948114"
   )
   boolean method919() {
      return this.field940;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1432781310"
   )
   int method921(int var1) {
      return this.field938[var1];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "106"
   )
   public static boolean method943(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;I)V",
      garbageValue = "-1973111092"
   )
   public static void method945(class103 var0, Object var1) {
      if(null != var0.field1677) {
         for(int var2 = 0; var2 < 50 && var0.field1677.peekEvent() != null; ++var2) {
            class115.method2292(1L);
         }

         if(null != var1) {
            var0.field1677.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2050083249"
   )
   public static int method947(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
