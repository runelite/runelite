import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("s")
   static int[] field1396;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2144305877
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 246000509
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   protected final Model getModel() {
      return class251.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Ldi;",
      garbageValue = "41"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class167.field2197, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(GameCanvas.field655 == 33) {
         var4 = "_rc";
      } else if(GameCanvas.field655 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(AttackOption.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
