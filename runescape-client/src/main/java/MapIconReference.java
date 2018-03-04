import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -335083075
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   public Coordinates field602;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   public Coordinates field596;

   @ObfuscatedSignature(
      signature = "(ILic;Lic;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field602 = var2;
      this.field596 = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "108514215"
   )
   static final void method711(PacketBuffer var0) {
      for(int var1 = 0; var1 < class93.field1410; ++var1) {
         int var2 = class93.field1414[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 32) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         class38.method517(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "20"
   )
   static final String method710(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + IndexFile.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + IndexFile.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + IndexFile.getColTags(16776960) + var1 + "</col>");
   }
}
