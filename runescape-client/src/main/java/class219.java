import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class219 implements class218 {
   @ObfuscatedName("u")
   public static final class219 field2782;
   @ObfuscatedName("h")
   public static final class219 field2783;
   @ObfuscatedName("a")
   public static final class219 field2784;
   @ObfuscatedName("q")
   public static final class219 field2785;
   @ObfuscatedName("g")
   public static final class219 field2786;
   @ObfuscatedName("v")
   public static final class219 field2787;
   @ObfuscatedName("t")
   public static final class219 field2788;
   @ObfuscatedName("p")
   public static final class219 field2789;
   @ObfuscatedName("i")
   public static final class219 field2791;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -689605483
   )
   public final int field2792;
   @ObfuscatedName("l")
   static final class219 field2793;
   @ObfuscatedName("aw")
   protected static boolean field2794;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZZ)V",
      garbageValue = "1"
   )
   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (class6[])null, var4, (class6[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "10"
   )
   class219(String var1, int var2) {
      this(var1, var2, false, (class6[])null, false, (class6[])null);
   }

   class219(String var1, int var2, class6[] var3, class6[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field2792;
   }

   class219(String var1, int var2, boolean var3, class6[] var4, boolean var5, class6[] var6) {
      this.field2792 = var2;
   }

   static {
      field2791 = new class219("", 10);
      field2783 = new class219("", 11);
      field2782 = new class219("", 12);
      field2785 = new class219("", 13);
      field2786 = new class219("", 14);
      field2787 = new class219("", 15, new class6[]{class6.field154, class6.field154}, (class6[])null);
      field2788 = new class219("", 16, new class6[]{class6.field154, class6.field154}, (class6[])null);
      field2789 = new class219("", 17, new class6[]{class6.field154, class6.field154}, (class6[])null);
      field2793 = new class219("", 73, true, true);
      field2784 = new class219("", 76, true, false);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "184013118"
   )
   static void method4130(Widget var0) {
      if(var0.field2774 == Client.field1094) {
         Client.field1095[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-120389242"
   )
   public static String method4131(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = MessageNode.method1133(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
