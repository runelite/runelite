import java.util.Calendar;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class36 {
   @ObfuscatedName("k")
   static int[][] field800 = new int[5][5000];
   @ObfuscatedName("d")
   static int[] field802;
   @ObfuscatedName("p")
   static String[] field805 = new String[1000];
   @ObfuscatedName("c")
   static String[] field806;
   @ObfuscatedName("y")
   static int[] field807 = new int[5];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 894371023
   )
   static int field808 = 0;
   @ObfuscatedName("m")
   static class14[] field809 = new class14[50];
   @ObfuscatedName("z")
   static Calendar field810 = Calendar.getInstance();
   @ObfuscatedName("i")
   static final String[] field811 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -14865065
   )
   static int field812 = 0;
   @ObfuscatedName("r")
   static int[] field813 = new int[1000];
   @ObfuscatedName("bc")
   static class168 field814;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "89"
   )
   public static boolean method830(int var0) {
      return 0 != (var0 >> 20 & 1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1517244997"
   )
   public static void method833() {
      try {
         if(1 == class183.field2967) {
            int var0 = class183.field2973.method3744();
            if(var0 > 0 && class183.field2973.method3736()) {
               var0 -= class59.field1228;
               if(var0 < 0) {
                  var0 = 0;
               }

               class183.field2973.method3677(var0);
               return;
            }

            class183.field2973.method3683();
            class183.field2973.method3747();
            if(null != class114.field1965) {
               class183.field2967 = 2;
            } else {
               class183.field2967 = 0;
            }

            class183.field2971 = null;
            class148.field2223 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2973.method3683();
         class183.field2967 = 0;
         class183.field2971 = null;
         class148.field2223 = null;
         class114.field1965 = null;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1037459942"
   )
   static final void method834() {
      int var0 = class32.field771;
      int[] var1 = class32.field762;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field550[var1[var2]];
         if(var3 != null) {
            class40.method932(var3, 1);
         }
      }

   }
}
