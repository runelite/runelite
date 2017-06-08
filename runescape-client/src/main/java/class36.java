import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class36 {
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 1287831249
   )
   static int field506;
   @ObfuscatedName("p")
   static final class36 field507;
   @ObfuscatedName("n")
   static final class36 field508;
   @ObfuscatedName("ae")
   static int[] field509;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2032358819
   )
   final int field511;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method493() {
      if(class154.field2241.toLowerCase().indexOf("microsoft") != -1) {
         class50.field636[186] = 57;
         class50.field636[187] = 27;
         class50.field636[188] = 71;
         class50.field636[189] = 26;
         class50.field636[190] = 72;
         class50.field636[191] = 73;
         class50.field636[192] = 58;
         class50.field636[219] = 42;
         class50.field636[220] = 74;
         class50.field636[221] = 43;
         class50.field636[222] = 59;
         class50.field636[223] = 28;
      } else {
         class50.field636[44] = 71;
         class50.field636[45] = 26;
         class50.field636[46] = 72;
         class50.field636[47] = 73;
         class50.field636[59] = 57;
         class50.field636[61] = 27;
         class50.field636[91] = 42;
         class50.field636[92] = 74;
         class50.field636[93] = 43;
         class50.field636[192] = 28;
         class50.field636[222] = 58;
         class50.field636[520] = 59;
      }

   }

   static {
      field508 = new class36(0);
      field507 = new class36(1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1595656655"
   )
   public static void method494() {
      Object var0 = class236.field3236;
      synchronized(class236.field3236) {
         if(class236.field3235 != 0) {
            class236.field3235 = 1;

            try {
               class236.field3236.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "122"
   )
   static final String method495(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field511 = var1;
   }
}
