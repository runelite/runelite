import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class13 {
   @ObfuscatedName("j")
   public static Comparator field288;
   @ObfuscatedName("z")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("n")
   public static Comparator field292;
   @ObfuscatedName("r")
   public static Comparator field290;
   @ObfuscatedName("v")
   public static Comparator field291;
   @ObfuscatedName("a")
   public final List field294;

   static {
      field288 = new class19();
      new class12();
      field292 = new class17();
      field290 = new class18();
      field291 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfe;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field294 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field294.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-1933170272"
   )
   public void method74(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field294, var1);
      } else {
         Collections.sort(this.field294, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1629426360"
   )
   static final void method77(int var0, int var1) {
      if(Client.field1120 == 2) {
         class48.method750((Client.hintArrowX - class163.baseX << 7) + Client.field929, (Client.hintArrowY - class10.baseY << 7) + Client.field930, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class23.pkIcons[0].method5032(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }
}
