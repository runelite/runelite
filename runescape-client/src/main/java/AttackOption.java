import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("u")
   static int[][] field1354;
   @ObfuscatedName("n")
   static int[] field1356;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1565234007
   )
   static int field1348;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -244735519
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-369819377"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "98048"
   )
   @Export("processClientError")
   public static void processClientError(String var0, Throwable var1) {
      if(var1 != null) {
         var1.printStackTrace();
      } else {
         try {
            String var2 = "";
            if(var1 != null) {
               var2 = JagexGame.method4521(var1);
            }

            if(var0 != null) {
               if(var1 != null) {
                  var2 = var2 + " | ";
               }

               var2 = var2 + var0;
            }

            System.out.println("Error: " + var2);
            var2 = var2.replace(':', '.');
            var2 = var2.replace('@', '_');
            var2 = var2.replace('&', '_');
            var2 = var2.replace('#', '_');
            if(RunException.field2198 == null) {
               return;
            }

            URL var3 = new URL(RunException.field2198.getCodeBase(), "clienterror.ws?c=" + RunException.revision + "&u=" + RunException.field2194 + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&e=" + var2);
            DataInputStream var4 = new DataInputStream(var3.openStream());
            var4.read();
            var4.close();
         } catch (Exception var5) {
            ;
         }

      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "882108004"
   )
   static final void method1903(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         if(Client.field1017) {
            int var2 = Client.menuOptionCount - 1;
            String var4;
            if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
               var4 = "Use" + " " + Client.lastSelectedItemName + " " + "->";
            } else if(Client.spellSelected && Client.menuOptionCount < 2) {
               var4 = Client.field1092 + " " + Client.field1028 + " " + "->";
            } else {
               String var5;
               if(var2 < 0) {
                  var5 = "";
               } else if(Client.menuTargets[var2].length() > 0) {
                  var5 = Client.menuOptions[var2] + " " + Client.menuTargets[var2];
               } else {
                  var5 = Client.menuOptions[var2];
               }

               var4 = var5;
            }

            if(Client.menuOptionCount > 2) {
               var4 = var4 + class45.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
            }

            MessageNode.fontBold12.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
         }
      }
   }
}
