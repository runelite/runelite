import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class224 {
   @ObfuscatedName("k")
   public final List field3227;
   @ObfuscatedName("q")
   public static Comparator field3228 = new class221();
   @ObfuscatedName("f")
   public static Comparator field3229;
   @ObfuscatedName("c")
   public static Comparator field3230;
   @ObfuscatedName("v")
   public static Comparator field3231;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-429114901"
   )
   public void method4034(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3227, var1);
      } else {
         Collections.sort(this.field3227, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class224(Buffer var1, boolean var2) {
      int var3 = var1.method2691();
      boolean var4 = var1.method2571() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2691();
      this.field3227 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3227.add(new class217(var1, var5, var3));
      }

   }

   static {
      new class222();
      field3229 = new class220();
      field3230 = new class216();
      field3231 = new class219();
   }
}
