import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class32 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -680854469
   )
   static int field717 = 0;
   @ObfuscatedName("i")
   static int[] field718;
   @ObfuscatedName("s")
   static Widget field719;
   @ObfuscatedName("k")
   static int[] field720 = new int[5];
   @ObfuscatedName("h")
   static int[][] field721 = new int[5][5000];
   @ObfuscatedName("o")
   static Calendar field722 = Calendar.getInstance();
   @ObfuscatedName("a")
   @Export("scriptStringStack")
   static String[] scriptStringStack = new String[1000];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1107468889
   )
   @Export("scriptStackCount")
   static int scriptStackCount = 0;
   @ObfuscatedName("z")
   @Export("scriptStack")
   static ScriptState[] scriptStack = new ScriptState[50];
   @ObfuscatedName("y")
   static final String[] field728 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("n")
   static int[] field729 = new int[1000];
   @ObfuscatedName("es")
   static ModIcon[] field732;
   @ObfuscatedName("t")
   static String[] field734;

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "100982705"
   )
   static final void method755(int var0, int var1, int var2, int var3, int var4) {
      class5.field47[0].method4191(var0, var1);
      class5.field47[1].method4191(var0, var1 + var3 - 16);
      Rasterizer2D.method4099(var0, var1 + 16, 16, var3 - 32, Client.field362);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4099(var0, var6 + var1 + 16, 16, var5, Client.field363);
      Rasterizer2D.method4108(var0, var6 + var1 + 16, var5, Client.field376);
      Rasterizer2D.method4108(1 + var0, 16 + var1 + var6, var5, Client.field376);
      Rasterizer2D.method4091(var0, var1 + 16 + var6, 16, Client.field376);
      Rasterizer2D.method4091(var0, var6 + 17 + var1, 16, Client.field376);
      Rasterizer2D.method4108(15 + var0, var1 + 16 + var6, var5, Client.field364);
      Rasterizer2D.method4108(14 + var0, var1 + 17 + var6, var5 - 1, Client.field364);
      Rasterizer2D.method4091(var0, var6 + 15 + var1 + var5, 16, Client.field364);
      Rasterizer2D.method4091(1 + var0, var5 + var6 + var1 + 14, 15, Client.field364);
   }
}
